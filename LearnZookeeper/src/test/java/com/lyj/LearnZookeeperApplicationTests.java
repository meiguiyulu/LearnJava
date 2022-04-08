package com.lyj;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.zookeeper.CreateMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnZookeeperApplicationTests {

    @Autowired
    CuratorFramework curatorFramework;

    @Test
    void contextLoads() {
    }

    @Test
    void createNode() throws Exception {
        // 持久节点
        String path = curatorFramework.create().forPath("/curator-node/test");
        //添加临时序号节点
        String path1 =
                curatorFramework.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/curator-EPHEMERAL_SEQUENTIAL-node", "some-data".getBytes());
        System.out.println(String.format("curator create node :%s successfully.", path));
        System.out.println(String.format("curator create EPHEMERAL_SEQUENTIAL node :%s successfully.", path1));
//        System.in.read();
    }

    // 获得节点数据
    @Test
    public void testGetData() throws Exception {
        byte[] bytes = curatorFramework.getData().forPath("/curator-node");
        System.out.println(new String(bytes));
    }

    // 修改节点数据
    @Test
    public void testSetData() throws Exception {
        curatorFramework.setData().forPath("/curator-node", "测试监视节点".getBytes());
        byte[] bytes = curatorFramework.getData().forPath("/curator-node");
        System.out.println(new String(bytes));
    }

    // 创建节点的同时创建父节点
    @Test
    public void testCreateWithParent() throws Exception {
        String path = "/parent/subNode1";
        String s = curatorFramework.create().creatingParentsIfNeeded().forPath(path, "创建节点的同时创建父节点".getBytes());
        System.out.println(String.format("curator create node :%s successfully.", s));
    }

    // 删除节点
    @Test
    public void testDelete() throws Exception {
        String path = "/parent";

        curatorFramework.delete().deletingChildrenIfNeeded().forPath(path);

    }

    // 获取读锁
    @Test
    public void testGetReadLock() throws Exception {
        InterProcessReadWriteLock interProcessReadWriteLock = new InterProcessReadWriteLock(curatorFramework, "/lock1");
        // 获取读锁对象
        InterProcessLock readLock = interProcessReadWriteLock.readLock();
        System.out.println("等待获取读锁对象");
        // 获取锁
        readLock.acquire();
        for (int i = 1; i <= 100; i++) {
            Thread.sleep(3000);
            System.out.println(i);
        }
        // 释放锁
        readLock.release();
        System.out.println("释放锁");
    }

    // 获取写锁
    @Test
    public void testGetWriteLock() throws Exception {
        InterProcessReadWriteLock interProcessReadWriteLock =
                new InterProcessReadWriteLock(curatorFramework, "/lock1");
        // 获取读锁对象
        InterProcessLock writeLock = interProcessReadWriteLock.writeLock();
        System.out.println("等待获取写锁对象");
        // 获取锁
        writeLock.acquire();
        for (int i = 1; i <= 100; i++) {
            Thread.sleep(3000);
            System.out.println(i);
        }
        // 释放锁
        writeLock.release();
        System.out.println("释放锁");
    }


    // 监听节点数据变化
    @Test
    public void addNodeLister() throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework, "/curator-node");
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点/curator-node 改变");
            }
        });
        nodeCache.start();
        printNodeData();
        System.in.read();
    }

    public void printNodeData() throws Exception {
        byte[] bytes = curatorFramework.getData().forPath("/curator-node");
        System.out.println(new String(bytes));
    }

}
