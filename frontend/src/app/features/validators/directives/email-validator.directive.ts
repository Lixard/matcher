import { Directive, forwardRef } from '@angular/core';
import {
  AbstractControl,
  NG_VALIDATORS,
  ValidationErrors,
  ValidatorFn,
} from '@angular/forms';

export const emailRegExp: ValidatorFn = (control) => {
  if (/[a-zA-Z\\d -_.]+@[a-zA-Z\\d -_.]{3,}/.test(control.value)) {
    // tslint:disable-next-line:no-null-keyword
    return null;
  }
  return {
    emailRegExp: true,
  };
};

@Directive({
  selector: '[appEmailValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => EmailValidatorDirective),
      multi: true,
    },
  ],
})
export class EmailValidatorDirective {
  constructor() {}

  validate(control: AbstractControl): ValidationErrors | null {
    return emailRegExp(control);
  }
}
