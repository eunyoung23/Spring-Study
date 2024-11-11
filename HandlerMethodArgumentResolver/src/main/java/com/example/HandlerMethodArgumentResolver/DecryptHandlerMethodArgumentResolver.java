package com.example.HandlerMethodArgumentResolver;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class DecryptHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(DecryptParams.class) &&
            parameter.getParameterType().equals(DecryptParams.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        /*
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        String newId = id + "12345";
        String newName = name + "0000";*/

        EncryptParam encryptParam = new EncryptParam();
        encryptParam.setId("11111");
        encryptParam.setName("2222222");

        return encryptParam;
    }
}
