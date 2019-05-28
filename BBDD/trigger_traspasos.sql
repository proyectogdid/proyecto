drop trigger if exists generar_traspaso;
delimiter |
create trigger generar_traspaso
after update on jugadores for each row 
BEGIN   
if new.equipo  <> old.equipo then
	insert into traspasos (jugador,equipoPrevio,equipoPosterior,fecha) values (new.id,old.equipo,new.equipo,curtime());-- SET contraseña= new.nombre; SET tas= new.dni;
end if;

END;
|