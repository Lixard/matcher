import {Directive, forwardRef} from '@angular/core';
import {AbstractControl, NG_VALIDATORS, ValidationErrors, ValidatorFn} from '@angular/forms';

export const phoneRegExp: ValidatorFn = (control) => {
  if (/\d{5,15}/.test(control.value)) {
    // tslint:disable-next-line:no-null-keyword
    return null;
  }
  return {
    phoneRegExp: true,
  };
};

@Directive({
  selector: '[appPhoneValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => PhoneValidatorDirective),
      multi: true,
    },
  ],
})
export class PhoneValidatorDirective {

  constructor() { }

  validate(control: AbstractControl): ValidationErrors | null {
    return phoneRegExp(control);
  }
}
