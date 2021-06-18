import {Directive, forwardRef} from '@angular/core';
import {AbstractControl, NG_VALIDATORS, ValidationErrors, ValidatorFn} from '@angular/forms';

export const nameRegExp: ValidatorFn = (control) => {
  if (/^.{1,50}$/.test(control.value)) {
    // tslint:disable-next-line:no-null-keyword
    return null;
  }
  return {
    nameRegExp: true,
  };
};

@Directive({
  selector: '[appNameValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(
        () => NameValidatorDirective
      ),
      multi: true
    }
  ]
})
export class NameValidatorDirective {

  constructor() { }

  validate(control: AbstractControl): ValidationErrors | null {
    return nameRegExp(control);
  }
}
