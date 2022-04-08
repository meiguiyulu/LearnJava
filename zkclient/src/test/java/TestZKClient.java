import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestZKClient {


    private ZkClient zkClient;

    @Test // 在zookeeper上创建节点
    public void testCreateNode() {
        // 1. 持久节点
        zkClient.create("/node1", "持久节点", CreateMode.PERSISTENT);
        // 2. 持久顺序(序号)节点
        zkClient.create("/node2", "持久顺序(序号)节点", CreateMode.PERSISTENT_SEQUENTIAL);
        // 3. 临时节点
        zkClient.create("/node3", "临时节点", CreateMode.EPHEMERAL);
        // 4. 临时顺序(序号)节点
        zkClient.create("/node4", "临时顺序(序号)节点", CreateMode.EPHEMERAL_SEQUENTIAL);
    }

    // 删除节点
    @Test
    public void testDeleteNode() {
        // 删除没有子节点的节点   返回值：是否删除成功
        boolean delete = zkClient.delete("/node1");

        // 乐观锁删除节点, 1表示期望的version  返回值：是否删除成功
        boolean delete1 = zkClient.delete("/node3", 1);

        // 递归删除节点信息 返回值：是否删除成功
        boolean deleteRecursive = zkClient.deleteRecursive("/node2");
    }

    // 查询当前节点下所有子节点
    @Test
    public void testFindNode() {
        // 获取指定节点下的节点信息     返回值：当前节点的子节点名称
        List<String> children = zkClient.getChildren("/");
        for (String child : children) {
            System.out.println(child);
        }
    }

    // 查看某个节点的数据 注意：通过java客户端操作需要保障节点存储时数据序列化和获取节点时数据序列化方式必须一致
    @Test
    public void testReadData() {
        Object data = zkClient.readData("/node1");
        System.out.println(data);
    }

    // 查看节点的数据并且获取状态信息
    @Test
    public void testFindNodeState() {
        Stat stat = new Stat();
        Object data = zkClient.readData("/node1", stat);
        System.out.println(data);
        System.out.println(stat);
    }

    // 修改节点信息
    @Test
    public void testUpdateData() {
        zkClient.writeData("/node1", new User(1, "name", 18, new Date()));
    }

    // 监听节点数据的变化
    @Test
    public void testOnNodeDataChange() throws IOException {
        zkClient.subscribeDataChanges("/node1", new IZkDataListener() {
            // 当节点的值修改时，会自动调用这个方法   将修改后的节点的名字和变化之后的数据传递给该方法
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("当前节点的路径：" + dataPath);
                System.out.println("变化后的数据： " + data);
            }

            // 当节点的值被删除的时候，会自动调用这个方法   将节点的名字用参数的形式传递给该方法
            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("当前节点的路径：" + dataPath);
            }
        });
        System.in.read(); // 阻塞当前监听
    }

    // 监听节点目录的变化
    @Test
    public void testOnNodeChange() throws IOException {
        // 当节点的目录发送变化时，会自动调用这个方法
        // 参数1：父节点名称
        // 参数2：父节点的所有子节点名称
        zkClient.subscribeChildChanges("/node1", new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("父节点名称： " + parentPath);
                System.out.println("发生变更后孩子节点名称： ");
                for (String child : currentChilds) {
                    System.out.println(child);
                }
            }
        });
        System.in.read();
    }

    @Before
        // 创建连接
    void before() {
        zkClient = new ZkClient(
                "127.0.0.1:2181",
                6000 * 30,
                6000,
                new SerializableSerializer()
        );
    }

    @After
        // 关闭连接
    void after() {
        zkClient.close();
    }


}
