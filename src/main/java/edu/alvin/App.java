package edu.alvin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Hello world!
 */
public class App {

    Class personClass;
    Class personClassFromObject;
    Class personClassForName;

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {

        System.out.println();

        App app = new App();
        app.init();
        System.out.println(">>>Methods:");
        app.printClassMethods();
        System.out.println(">>>Fields:");
        app.printClassFields();
        System.out.println(new Person());

        //        app.createObjectFromScanner();

    }

    private void createObjectFromScanner()
            throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException,
            InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        //        class_name1
        Class<?> classObj1 = Class.forName(scanner.next());
        //        class_name2
        Class<?> classObj2 = Class.forName(scanner.next());
        //        method_name
        String methodName = scanner.next();

        Method method = classObj1.getMethod(methodName, classObj2);

        Object object1 = classObj1.newInstance();
        Object object2 = classObj2.getConstructor(String.class)
                .newInstance("Modified string value");
        /*
         * object1 - object to modify (Person here)
         * object2 - string value to set as argument (setName method here)
         */
        method.invoke(object1, object2);

        System.out.println(object1);
        System.out.println(object2);
    }

    private void printClassFields() {
        Field[] fields = personClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.printf("%s%n", field.getName());
        }
    }

    private void printClassMethods() {
        Method[] methods = personClass.getMethods();

        for (Method method : methods) {
            System.out.printf("%s, %s, %s%n", method.getName(),
                    method.getReturnType(),
                    Arrays.toString(method.getParameterTypes()));
        }
    }

    private void init() throws ClassNotFoundException {
        Person person = new Person();
        personClass = Person.class;
        personClassFromObject = person.getClass();
        personClassForName = Class.forName("edu.alvin.Person");
    }
}
