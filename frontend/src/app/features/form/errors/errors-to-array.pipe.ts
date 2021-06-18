import { Pipe, PipeTransform } from '@angular/core';
import { ValidationErrors } from '@angular/forms';

@Pipe({
  name: 'errorsToArray'
})
export class ErrorsToArrayPipe implements PipeTransform {

  transform(value: ValidationErrors | undefined): string[] | undefined {
    if (value == undefined) {
      return undefined;
    }
    return Object.keys(value);
  }

}
