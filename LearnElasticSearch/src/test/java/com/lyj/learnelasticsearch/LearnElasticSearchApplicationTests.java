package com.lyj.learnelasticsearch;

import com.alibaba.fastjson.JSON;
import com.lyj.learnelasticsearch.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class LearnElasticSearchApplicationTests {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    // 测试索引的创建
    @Test
    void testCreateIndex() throws IOException {
        /*1. 创建索引请求*/
        CreateIndexRequest request = new CreateIndexRequest("test_index");
        /*2. 执行请求响应*/
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    /*测试删除索引*/
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("test_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    /*测试添加文档*/
    @Test
    public void testAddDocument() throws IOException {
        // 创建一个User对象
        User user = new User("刘云杰", 23);
        // 创建请求
        IndexRequest request = new IndexRequest("test_index");
        // 制定规则 PUT /liuyou_index/_doc/1
        request.id("1");// 设置文档ID
        request.timeout(TimeValue.timeValueMillis(1000));// request.timeout("1s")
        // 将我们的数据放入请求中
        request.source(JSON.toJSONString(user), XContentType.JSON);
        // 客户端发送请求，获取响应的结果
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.status());// 获取建立索引的状态信息
        System.out.println(response);// 查看返回内容

        /*
         * CREATED
         * IndexResponse[index=test_index,type=_doc,id=1,version=1,result=created,seqNo=0,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
         * */
    }

    // 测试获得文档信息
    @Test
    public void testGetDocument() throws IOException {
        GetRequest request = new GetRequest("test_index", "1");
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());// 打印文档内容
        System.out.println(request);// 返回的全部内容和命令是一样的
        restHighLevelClient.close();
    }

    /*获取文档*/
    @Test
    void testIsExists() throws IOException {
        GetRequest request = new GetRequest("test_index", "1");
        // 不获取返回的 _source的上下文了
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");

        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 测试更新文档内容
    @Test
    public void testUpdateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("test_index", "1");
        User user = new User("lmk", 11);
        request.doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response.status()); // OK
        restHighLevelClient.close();
    }

    // 测试删除文档
    @Test
    public void testDeleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("test_index", "1");
        request.timeout("1s");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());// OK
    }

    // 查询
    // SearchRequest 搜索请求
    // SearchSourceBuilder 条件构造
    // HighlightBuilder 高亮
    // TermQueryBuilder 精确查询
    // MatchAllQueryBuilder
    // xxxQueryBuilder ...
    @Test
    public void testSearch() throws IOException {
        // 1.创建查询请求对象
        SearchRequest searchRequest = new SearchRequest();
        // 2.构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // (1)查询条件 使用QueryBuilders工具类创建
        // 精确查询
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "liuyou");
        //        // 匹配查询
        //        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        // (2)其他<可有可无>：（可以参考 SearchSourceBuilder 的字段部分）
        // 设置高亮
        searchSourceBuilder.highlighter(new HighlightBuilder());
        //        // 分页
        //        searchSourceBuilder.from();
        //        searchSourceBuilder.size();
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        // (3)条件投入
        searchSourceBuilder.query(termQueryBuilder);
        // 3.添加条件到请求
        searchRequest.source(searchSourceBuilder);
        // 4.客户端查询请求
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 5.查看返回结果
        SearchHits hits = search.getHits();
        System.out.println(JSON.toJSONString(hits));
        System.out.println("=======================");
        for (SearchHit documentFields : hits.getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }

    // 特殊的，真的项目一般会 批量插入数据
    @Test
    public void testBulk() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("liuyou-1",1));
        users.add(new User("liuyou-2",2));
        users.add(new User("liuyou-3",3));
        users.add(new User("liuyou-4",4));
        users.add(new User("liuyou-5",5));
        users.add(new User("liuyou-6",6));
        // 批量请求处理
        for (int i = 0; i < users.size(); i++) {
            bulkRequest.add(
                    // 这里是数据信息
                    new IndexRequest("bulk")
                            .id(""+(i + 1)) // 没有设置id 会自定生成一个随机id
                            .source(JSON.toJSONString(users.get(i)),XContentType.JSON)
            );
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());// ok
    }
}
