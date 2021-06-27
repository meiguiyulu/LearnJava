package service;

import dao.UseDao;
import dao.UseDaoImpl;

/**
 * @author LYJ
 * @create 2021-06-26 14:29
 */
public class UseServiceImpl implements UseService{

    private UseDao useDao;

    /**
     * 利用set动态实现值的注入
     * @param useDao
     */
    public void setUseDao(UseDao useDao) {
        this.useDao = useDao;
    }

    @Override
    public void getUser() {
        useDao.getUser();
    }
}
