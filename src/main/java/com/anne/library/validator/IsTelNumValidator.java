package com.anne.library.validator;

import com.anne.library.utils.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class IsTelNumValidator implements ConstraintValidator<IsTelNum, String> {

    private boolean required;
    @Override
    public void initialize(IsTelNum constraintValidation) {
        required = constraintValidation.required();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtil.isTelNum(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidatorUtil.isTelNum(value);
            }
        }
    }
}