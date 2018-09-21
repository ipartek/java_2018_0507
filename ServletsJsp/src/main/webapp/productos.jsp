<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail primer">
                       <!--<div class="col-xs-1 segundo"><p>20%</p></div>-->
                        <div class="row">
                            <img src="imgs/100x140.png">
                        </div>
                        <div class="row precio">0,50â¬</div>
                        <div class="row precioxq">1â¬/litro</div>
                        <div class="row nombre">1/2 Leche</div>
                         <div class="input-group">
                            <span class="input-group-btn btnMenos">
                                <button type="button" class="btn btn-danger btn-number" data-type="minus" data-field="quant[2]">
                                    <span class="glyphicon glyphicon-minus"></span>
                                </button>
                            </span>
                            <input type="text" name="quant[2]" class="form-control input-number" value="0" min="1" max="100">
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-success btn-number" data-type="plus" data-field="quant[2]">
                                    <span class="glyphicon glyphicon-plus"></span>
                                </button>
                            </span>
                        </div>
                        <div class="row text-center"><button type="button" class="btn btn-success aniadir">A&ntilde;adir</button></div>
                    </div>