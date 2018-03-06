import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'interpol',
  templateUrl: './interpol.component.html',
  styleUrls: ['./app.component.css']
})
export class InterpolComponent {

  mas: Points;
  interpolp: Line;
  result: string = '';
  p1: Point;
  d1:Dat;

  public lineChartData: Array<any>;
  public lineChartLabels:Array<any>;
  // i: number=0;
  constructor(private http: HttpClient) {
    this.mas = new Points();
    this.mas.points = [];
    this.interpolp= new Line();
    this.interpolp.x_mas = [];
    this.interpolp.y_mas = [];
    this.lineChartData=[];
    this.lineChartLabels=[];
    this.d1=new Dat();
    this.d1.data=[];
  }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  }

  add() {
    this.p1 = new Point(this['x_input'], this['y_input']);
    this.mas.points.push(this.p1);
    this.lineChartData.push(this.p1);
  }

  delete() {
    this.mas.points.pop();
  }

  clear() {
    this.mas.points = [];
  }

  interpol() {
    console.log(JSON.stringify(this.mas.points));
    this.http.post('http://localhost:8282/webService_war_exploded/service/interpol',
      JSON.stringify(this.mas.points), this.httpOptions)
      .subscribe((data) => {
        this.interpolp = data as Line;
        this.d1.data=this.interpolp.y_mas;
        this.d1.label='interpolated';
        this.lineChartData.push(this.d1);
        this.lineChartLabels=this.interpolp.x_mas;
      });

  }


  public lineChartOptions: any = {
    responsive: true
  };
  public lineChartColors: Array<any> = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    },
    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    }
  ];
  public lineChartLegend: boolean = true;
  public lineChartType: string = 'line';


}

export class Point{
  x: number;
  y: number;
  constructor(x,y){
    this.x=x;
    this.y=y;
  }
}
export class Points{
  points: Point[];
}
export class Line{
  y_mas:number[];
  x_mas:number[];
}
export class Dat{
  data:number[];
  label:string;
}
