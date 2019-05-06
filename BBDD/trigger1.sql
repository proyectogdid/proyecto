delimiter |
create trigger generar_evento
after update on jugadores for each row 
BEGIN   
if new.estado  <> old.estado then
	insert into eventos (jugador,estadoPrevio,estadoPosterior) values (new.id,old.estado,new.estado);-- SET contraseña= new.nombre; SET tas= new.dni;
end if;
  /*INSERT INTO evento values(1,2);*/
END;
|