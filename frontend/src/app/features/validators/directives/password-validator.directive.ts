import {Directive, forwardRef} from '@angular/core';
import {AbstractControl, NG_VALIDATORS, ValidationErrors, ValidatorFn} from '@angular/forms';

export const passwordRegExp: ValidatorFn = (control) => {
  if (/^.{8,50}$/.test(control.value)) {
    // tslint:disable-next-line:no-null-keyword
    return null;
  }
  return {
    phoneRegExp: true,
  };
};

@Directive({
  selector: '[appPasswordValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => PasswordValidatorDirective),
      multi: true,
    },
  ],
})
export class PasswordValidatorDirective {

  constructor() {
  }

  validate(control: AbstractControl): ValidationErrors | null {
    return passwordRegExp(control);
  }
}
