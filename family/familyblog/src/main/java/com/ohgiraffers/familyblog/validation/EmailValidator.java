package com.ohgiraffers.familyblog.validation; // 패키지 선언: 이 클래스가 포함된 패키지를 지정한다.

import javax.validation.ConstraintValidator;// 이메일 유효성 검사를 위한 인터페이스와 유효성 검사 컨텍스트를 임포트한다.
import javax.validation.ConstraintValidatorContext;

// EmailValidator 클래스는 유효성 검사 인터페이스를 구현한다.
// 유효성 검사를 위해 ConstraintValidator<ValidEmail.String>을 사용한다.
// ValidEmail 어노테이션과 함께 String 타입의 데이터를 검증한다.
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    //유효성 검사가 시작되기 전에 초기화 작업을 할 수 있는 메서드이다.
    // 여기서는 초기화 작업이 필요 없으므로 빈 메서드로 유지된다.
    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        //초기화 코드가 필요할 경우 여기에 추가한다.

    }

    // 이메일 유효성 검사 로직을 구현하는 메서드이다.
    // 입력된 이메일(String)이 유효한지 검사하고, 유효하면 true를,유효하지 않으면 false를 반환한다.
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        // 이메일 null이 아니고,"@"문자를 포함하고 있는지 확인한다.
        // 간단한 유효성 검사로, 실제로는 더 복잡한 로직이 필요할 수 있다.
        return email != null && email.contains("@");
    }
}