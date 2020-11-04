import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../../servicos/cliente.service';
import { ServicosService } from '../../../servicos/servicos.service';
import { Cliente } from '../../clientes/cliente';
import { Servico } from '../servico';
@Component({
  selector: 'app-servicos-form',
  templateUrl: './servicos-form.component.html',
  styleUrls: ['./servicos-form.component.css']
})
export class ServicosFormComponent implements OnInit {
  errors:string[];
  sucesso:string;
  servico: Servico;
  clientes: Cliente[] = [];
  idSelecionado: number;
  constructor(private clienteService:ClienteService,private servicosService:ServicosService) {
    this.servico = new Servico();
  }
  ngOnInit(): void {
  	  this.clienteService.getClientes()
  	  .subscribe( clientes => {
  	  	 this.clientes = clientes;
  	  	 console.log(this.clientes)
  	  })
  }

  public onSubmit(){
     this.servicosService
       .salvar(this.servico)
       .subscribe( response => {
           this.sucesso = "Sucesso ao adicionar Serviço !";
       }, errors => {
           this.errors = errors.error.errors ;
       });
  }
}