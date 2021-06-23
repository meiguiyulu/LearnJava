package LearnJUC.Single;

/**
 * @author LYJ
 * @create 2021-05-13 11:44
 */
public enum EnumSingle {
    instance;
    public EnumSingle getInstance(){
        return instance;
    }
}
