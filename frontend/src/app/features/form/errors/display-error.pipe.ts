import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'displayError'
})
export class DisplayErrorPipe implements PipeTransform {

  transform(value: string): string {
    switch (value) {
      case 'emailRegExp':
        return 'Почта имеет неправильный формат';
      case 'nameRegExp':
        return 'Имя недопустимо';
      case 'phoneRegExp':
        return 'Phone is invalid';
      case 'userNameRegExp':
        return 'Введите, пожалуйста, username, начинающийся с латиницы';
      case 'required':
        return ;
      default:
        return value;
    }
  }

}
