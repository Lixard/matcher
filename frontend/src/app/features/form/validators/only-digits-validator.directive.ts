import { Directive, forwardRef } from '@angular/core';
import {
  AbstractControl,
  NG_VALIDATORS,
  ValidationErrors,
  Validator,
  ValidatorFn
} from '@angular/forms';

export const onlyDigits: ValidatorFn = (control) => {
  if (/^\d+$/.test(control.value as string)) {
    // tslint:disable-next-line:no-null-keyword
    return null;
  }
  return {
    onlyDigits: true
  };
};

@Directive({
  selector: '[appOnlyDigitsValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(
        () => OnlyDigitsValidatorDirective
      ),
      multi: true
    }
  ]
})
export class OnlyDigitsValidatorDirective
  implements Validator {
  constructor() {}

  validate(
    control: AbstractControl
  ): ValidationErrors | null {
    return onlyDigits(control);
  }
}
