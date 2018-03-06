import { Component } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'integr',
  templateUrl: './integr.component.html',
  styleUrls: ['./app.component.css']
})
export class IntegrComponent {
  c_x3 : string = '';
  c_x2 : string = '';
  c_x : string = '';
  c : string = '';
  numStep : string = '';
  a : string = '';
  b : string = '';
  metod: string = '';
  result: string = '';
  public resultbd1: Array<Operation>;

  constructor(private http: HttpClient) {
    this.resultbd1 = [];
  }

  decide() {
    if (this.c_x3 != '' && this.c_x2 != '' && this.c_x != '' && this.c != '' && this.a != ''&& this.b != ''&& this.numStep != '') {
    this.http.get('http://localhost:8282/webService_war_exploded/service/integr/' + this.c_x3 + '/' +this.c_x2 + '/' +
      this.c_x + '/' + this.c + '/' + this.a + '/' + this.b + '/' + this.numStep + '/' + this.metod).subscribe((data) =>
      {
          this.result = data.toString();
      });
    }
  }
  integrbd(){
    this.http.get('http://localhost:8282/webService_war_exploded/service/integrbd')
      .subscribe((data) => {
        this.resultbd1 = data as Array<Operation>;
      });
  }
}

export class Operation{
  id: number;
  cX3: number;
  cX2: number;
  cX: number;
  c: number;
  numSteps: number;
  leftLimit: number;
  rightLimit: number;
  answer: number;
  constructor(id, cX3, cX2, cX, c, numSteps, leftLimit, rightLimit, answer){
    this.id = id;
    this.cX3 = cX3;
    this.cX2 = cX2;
    this.cX = cX;
    this.c = c;
    this.numSteps = numSteps;
    this.leftLimit = leftLimit;
    this.rightLimit = rightLimit;
    this.answer = answer;
  }
}
