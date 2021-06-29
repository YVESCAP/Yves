create or replace PACKAGE PKG_VIDEOJUEGO AS 

  /* TODO enter package declarations (types, exceptions, methods etc) here */ 
  procedure carga_juego;
  procedure carga_notas_juego;
  
END PKG_VIDEOJUEGO;
/

create or replace PACKAGE BODY PKG_VIDEOJUEGO AS

  procedure carga_juego AS
  BEGIN
    /* carga tabla JUEGO con los datos que provienen de tabla Temporal */
    merge into juego tab
    using (select distinct con.ID_CONSOLA
            ,upper(TMP.NOMBRE_JUEGO) nombre_juego
           from tmp_videogame tmp
                ,consola con
           where upper(tmp.nombre_consola) = con.NOMBRE_CONSOLA
          ) tmp
    on (tab.nombre_juego = tmp.nombre_juego)
    when not matched then
        insert (id_juego, id_consola, nombre_juego)
            values (SEQ_VIDEOJUEGO.nextval, tmp.id_consola, tmp.nombre_juego)
    ;
    commit;
  END carga_juego;

  procedure carga_notas_juego AS
  BEGIN
    /* se cambia lenguaje por datos de fecha en tabla temporal */
    EXECUTE IMMEDIATE 'ALTER SESSION SET NLS_LANGUAGE= "AMERICAN"' ;
    
    /* inserta datos desde tabla temporal a tabla de Notas */
    insert into ranking_juego(id_ranking, id_juego, nota_usuario, fecha_nota, metascore)
        select SEQ_RANKING_JUEGO.nextval
            ,JUE.ID_JUEGO
            ,decode(tmp.NOTA_USUARIO,'tbd',-1
                                    ,'userscore',-1
                                    ,to_number(replace(tmp.NOTA_USUARIO,'.',','))
                    ) nota
            ,to_date(TMP.FECHA_NOTA,'MONTH dd,yyyy')
            ,to_number(tmp.metascore) metascore
        from juego jue
            ,consola con
            ,tmp_videogame tmp
        where upper(TMP.NOMBRE_JUEGO) = upper(JUE.NOMBRE_JUEGO)
        and upper(tmp.nombre_consola) = upper(con.NOMBRE_CONSOLA)
        and con.ID_CONSOLA = JUE.ID_CONSOLA
    ;
    commit;
  END carga_notas_juego;

END PKG_VIDEOJUEGO;