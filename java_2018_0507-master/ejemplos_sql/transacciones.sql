-- En MySQL Workbench ejecutar con el rayo del cursor cada línea por separado

start transaction; -- o BEGIN: Iniciar una transacción sin auto commit

delete from videos where id=1;
delete from videos where id=2;
select * from videos;

rollback; -- Cancelar y cerrar la transacción y activar de nuevo auto commit

commit; -- Confirmar y cerrar la transacción y activar de nuevo auto commit
