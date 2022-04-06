import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  description: string = 'Это площадка для студентов, где они смогут искать\n' +
    '            различные проекты от компаний, либо предлагать компаниям свои. Группа студентов может придумать и начать\n' +
    '            реализовывать какой-то проект, и выложить его на общую "биржу", где заинтересованные компании могут\n' +
    '            связаться с ними. Так же компании, у которых, возможно, есть какие-то идеи для проектов, на которые они не\n' +
    '            могут тратить ресурсы компании, дают возможность студентам поучаствовать в них. Присоединяйтесь\n' +
    '            к нам!';

  constructor() {
  }

  ngOnInit(): void {
  }

}
