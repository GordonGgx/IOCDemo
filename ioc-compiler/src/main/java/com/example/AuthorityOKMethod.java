package com.example;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

/**
 * Created by jerry.guan on 4/21/2017.
 */

public class AuthorityOKMethod {

    private ExecutableElement executableElement;
    private int requestCode;

    public AuthorityOKMethod(Element element) {
        if(element.getKind()!= ElementKind.METHOD){
            throw new RuntimeException("Only methods can be annotation!");
        }
        this.executableElement= (ExecutableElement) element;
        requestCode=executableElement.getAnnotation(AuthorityOK.class).value();
    }

    /**
     * 获取成功回调方法的名字
     */
    public Name getName(){
        return executableElement.getSimpleName();
    }

    /**
     * 获取成功回调方法的参数列表
     */
    public List<? extends VariableElement> getParameters(){
        return executableElement.getParameters();
    }

    /**
     * 获取成功回调方法的返回类型
     */
    public TypeMirror getReturnType(){
        return executableElement.getReturnType();
    }

    /**
     * 获取方法的requestCode
     */
    public int getRequestCode(){
        return requestCode;
    }
}
