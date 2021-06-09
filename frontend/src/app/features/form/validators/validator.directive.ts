import { Directive, forwardRef, Input } from '@angular/core';
import {
  AbstractControl,
  NG_VALIDATORS,
  ValidationErrors,
  Validator,
  ValidatorFn,
} from '@angular/forms';

@Directive({
  selector: '[appValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => ValidatorDirective),
      multi: true,
    },
  ],
})
export class ValidatorDirective implements Validator {
  @Input() appValidator: ValidatorFn;

  constructor() {}

  validate(control: AbstractControl): ValidationErrors | null {
    return this.appValidator(control);
  }
}
