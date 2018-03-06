import { Component } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'calc',
  templateUrl: './calc.component.html',
  styleUrls: ['./app.component.css']
})
export class CalcComponent {

  result: string = '';
  firstOperand: string = '';
  secondOperand: string = '';
  operation: string = '';
  public resultbd1: Array<Operation>;

  constructor(private http: HttpClient) {
    this.resultbd1 = [];

  }

  append(element: string) {
    if (this.secondOperand == '' && this.operation == '') {
      this.firstOperand += element;
      this.result += element;
    }
    if (this.firstOperand != '' && this.operation != '') {
      this.secondOperand += element;
      this.result += element;
    }
  }
  clear(){
    this.result = '';
    this.firstOperand = '';
    this.secondOperand = '';
    this.operation = '';
  }

  operations(element: string) {
    if (this.secondOperand == '' && this.operation == '' && this.firstOperand != '') {
      this.operation += element;
      this.result += element;
    }
    if (this.secondOperand != '' && this.operation != '' && this.firstOperand != '') {
      this.http.get('http://localhost:8282/webService_war_exploded/service/calc/' + this.operation +
        '/' + this.firstOperand + '/' + this.secondOperand)
        .subscribe((data) => {
          this.result = data.toString();
          this.firstOperand = this.result;
          this.operation = element;
          this.secondOperand = '';
          if (element != '=') {
            this.result += element;
            this.operation = element;
          }
          else {
            this.operation = '';
          }
        });
    }

  }

  calcbd(){
    this.http.get('http://localhost:8282/webService_war_exploded/service/calcbd')
      .subscribe((data) => {
        this.resultbd1 = data as Array<Operation>;
      });
  }
}
export class Operation{
  id: number;
  firstOperand: number;
  secondOperand: number;
  operation: string;
  answer: number;
  constructor(id, firstOperand, secondOperand, operation, answer){
    this.id = id;
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
    this.operation = operation;
    this.answer = answer;
  }
}

