import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'slau',
  templateUrl: './slau.component.html',
  styleUrls: ['./app.component.css']
})
export class SlauComponent {
  mas: number[][];

  matrix: Matrix;
  public resultbd1: Array<Operation>;

  constructor(private http: HttpClient) {
    this.matrix = {
      data: [[]],
      mat_size: 0
    };
    this.resultbd1 = [];
  }


  count: string = '2';
  k: number = 0;
  result: string = '';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })

  };


  decide() {
    this.mas = [];
    for (let i: number = 0; i < Number(this.count); i++) {
      this.mas[i] = [];
      for (let j: number = 0; j <= Number(this.count); j++) {
        this.mas[i][j] = Number(this["m" + this.k]);
        console.log("m" + this.k);
        this.k++;

      }
      this.k += (6 - Number(this.count));
    }

    this.matrix.data = this.mas;
    this.matrix.mat_size = Number(this.count);
    console.log(JSON.stringify(this.matrix));

    this.http.post('http://localhost:8282/webService_war_exploded/service/slau',
      JSON.stringify(this.matrix), this.httpOptions)
      .subscribe((data) => {
        this.result = data.toString().replace(/!/g, '\n');
    });
  }

  slaubd() {
    this.http.get('http://localhost:8282/webService_war_exploded/service/slaubd')
      .subscribe((data) => {
        this.resultbd1 = data as Array<Operation>;
        for(let el of this.resultbd1){
          el.equations = el.equations.replace(/!/g, '\n');
          el.answer = el.answer.replace(/!/g, '\n');
        }
      });
  }
}

export class Matrix {
  data: number[][];
  mat_size: number;
}
export class Operation {
  id: number;
  sizeSlau: number;
  equations: string;
  answer: string;

  constructor(id, sizeSlau, equations, answer) {
    this.id = id;
    this.sizeSlau = sizeSlau;
    this.equations = equations;
    this.answer = answer;
  }
}
