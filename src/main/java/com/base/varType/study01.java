package com.base.varType;

import java.lang.reflect.Method;

public class study01 {

    public static void main(String[] args) {
        test2();
    }

    /*
    基本数据类型	封装数据类型	类型描述	字节数	范围
    byte	Byte	整型	1	[-128, 127]
    short	Short	整型	2	[- 32768, 32767] or [-2^15, 2^15-1]
    int	    Integer	整型	4	[-2^31, 2^31-1]
    long	Long	长整型	8	[-2^63, 2^63 -1]
    float	Float	单精度浮点型	4	-
    double	Double	双精度浮点型	8	-
    char	Character	字符型	2	[0, 65535]
    boolean	Boolean	布尔类型	>1	-
    * */
    public static void test1(Class<?> returnType, Object object) {
        if (returnType.equals(byte.class)) {
            Byte var_Byte = (Byte) object;
            byte var_byte = var_Byte.byteValue();
            System.out.println(var_byte);
        } else if (returnType.equals(short.class)) {
            Short var_Short = (Short) object;
            short var_shor = var_Short.shortValue();
            System.out.println(var_shor);
        } else if (returnType.equals(int.class)) {
            Integer var_Integer = (Integer) object;
            int var_int = var_Integer.intValue();
            System.out.println("var_int = " + var_int);
        } else if (returnType.equals(long.class)) {
            Long var_Long = (Long) object;
            long var_long = var_Long.longValue();
            System.out.println(var_long);
        } else if (returnType.equals(float.class)) {
            Float var_Float = (Float) object;
            float var_float = var_Float.floatValue();
            System.out.println(var_float);
        } else if (returnType.equals(double.class)) {
            Double var_Double = (Double) object;
            double var_double = var_Double.doubleValue();
            System.out.println(var_double);
        } else if (returnType.equals(char.class)) {
            Character var_Character = (Character) object;
            char var_char = var_Character.charValue();
            System.out.println(var_char);
        } else if (returnType.equals(boolean.class)) {
            Boolean var_Boolean = (Boolean) object;
            boolean var_boolean = var_Boolean.booleanValue();
            System.out.println(var_boolean);
        }
    }

    // 反射调用
    public static void test2() {
        try {
            Integer varInteger = 10;
            //        varInt = varInteger.intValue();
            Method method = Integer.class.getDeclaredMethod("intValue");
            Object result = method.invoke(varInteger);
            System.out.println(result);
            if (result != null) {
                int varInt = (int) result;
                System.out.println(varInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
