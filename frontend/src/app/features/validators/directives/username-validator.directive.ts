import { Directive, forwardRef } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, ValidatorFn } from '@angular/forms';

export const userNameRegExp: ValidatorFn = (control) => {
  if (/^[a-zA-Z\-]{1,}/.test(control.value)) {
    // tslint:disable-next-line:no-null-keyword
    return null;
  }
  return {
    userNameRegExp: true
  };
};

@Directive({
  selector: '[appUsernameValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => UsernameValidatorDirective),
      multi: true
    }
  ]
})
export class UsernameValidatorDirective {
  constructor() {}

  validate(control: AbstractControl): ValidationErrors | null {
    return userNameRegExp(control);
  }
}
