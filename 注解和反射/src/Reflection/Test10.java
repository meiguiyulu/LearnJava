package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// 通过反射获取泛型
public class Test10 {

    public void test01(Map<String, User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String, User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        /**
         * 参数化类型
         */
        Method method = Test10.class.getMethod("test01", Map.class, List.class);

        Type[] types = method.getGenericParameterTypes();
        for (Type type: types){
            System.out.println("####\t" + type);
            if (type instanceof ParameterizedType){
                Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
                for (Type argument: arguments){
                    System.out.println(argument);
                }
            }
        }


        System.out.println("====================================================");
        /**
         * 返回值类型
         */
        method = Test10.class.getMethod("test02", null);
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType){
            Type[] Arguments = ((ParameterizedType) returnType).getActualTypeArguments();
            for (Type argument: Arguments){
                System.out.println(argument);
            }
        }

    }
}
