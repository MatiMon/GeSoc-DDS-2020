
    create table categoria_entidad (
        id bigint not null auto_increment,
        nombre varchar(255),
        primary key (id)
    )

    create table ciudad (
        id varchar(255) not null,
        nombre varchar(255),
        provincia_id varchar(255),
        primary key (id)
    )

    create table comportamiento_categoria (
        tipo_categoria varchar(31) not null,
        id bigint not null auto_increment,
        encendido bit,
        tipo_comportamiento varchar(255),
        categoria_entidad_id bigint,
        primary key (id)
    )

    create table direccion (
        id bigint not null auto_increment,
        calle varchar(255),
        ciudad varchar(255),
        nro_calle varchar(255),
        pais varchar(255),
        piso varchar(255),
        provincia varchar(255),
        unidad varchar(255),
        primary key (id)
    )

    create table entidad_base (
        id bigint not null,
        descripcion varchar(255),
        nombre_ficticio varchar(255),
        categoria_id bigint,
        entidad_juridica_id bigint,
        primary key (id)
    )

    create table entidad_juridica (
        id bigint not null,
        IGJ_id varchar(255),
        codigo_id integer,
        monto_maximo_de_egresos double precision,
        nombre_ficticio varchar(255),
        razon_social varchar(255),
        tipo_entidad_juridica varchar(255),
        tipo_codigo_id integer,
        valor_total_montos double precision,
        categoria_id bigint,
        direccion_id bigint,
        organizacion_id bigint,
        primary key (id)
    )

    create table etique_egreso_gastos (
        etiqueta_egreso_id bigint not null,
        valor double precision,
        moneda_id bigint not null,
        primary key (etiqueta_egreso_id, moneda_id)
    )

    create table etiqueta_egreso (
        id bigint not null auto_increment,
        tipo_etiqueta_id bigint,
        primary key (id)
    )

    create table item (
        id bigint not null auto_increment,
        cantidad integer not null,
        operacion_de_egreso_id bigint,
        presupuesto_id bigint,
        producto_id varchar(255),
        primary key (id)
    )

    create table medios_de_pago (
        tipo_pago varchar(1) not null,
        id bigint not null auto_increment,
        fecha_vencimiento datetime,
        nombre_completo varchar(255),
        numero_tarjeta varchar(255),
        tipo_tarjeta integer,
        codigo_pago varchar(255),
        primary key (id)
    )

    create table mensaje (
        id bigint not null auto_increment,
        descripcion varchar(255),
        fecha_y_hora tinyblob,
        leido bit not null,
        usuario_id bigint,
        primary key (id)
    )

    create table moneda (
        id bigint not null auto_increment,
        descripcion varchar(255),
        identificador varchar(255),
        simbolo varchar(255),
        primary key (id)
    )

    create table operacion_de_egreso (
        id bigint not null auto_increment,
        cantidad_presupuestos_requeridos integer,
        fecha_operacion datetime,
        informada bit,
        numero_documento_comercial integer,
        path_archivo varchar(255),
        tipo_documento_comercial varchar(255),
        valor_total double precision,
        entidad_id bigint,
        medios_de_pago_id bigint,
        moneda_id bigint,
        proveedor_id bigint,
        usuarioAlta_id bigint,
        primary key (id)
    )

    create table operacion_de_egreso_etiqueta (
        etiqueta_id bigint not null,
        operacion_id bigint not null
    )

    create table operacion_de_egreso_usuario (
        usuario_id bigint not null,
        operacion_id bigint not null
    )

    create table organizacion (
        id bigint not null auto_increment,
        nombre varchar(255),
        primary key (id)
    )

    create table pais (
        id varchar(255) not null,
        nombre varchar(255),
        primary key (id)
    )

    create table presupuesto (
        id bigint not null auto_increment,
        valor_total double precision,
        operacion_de_egreso_id bigint,
        primary key (id)
    )

    create table presupuesto_tipo_documento (
        presupuesto_id bigint not null,
        documento_comercial varchar(255)
    )

    create table producto (
        id varchar(255) not null,
        nombre varchar(255),
        precio_unitario double precision,
        primary key (id)
    )

    create table proveedor (
        id bigint not null auto_increment,
        codigo_id integer,
        razon_social varchar(255),
        tipo_codigo_id integer,
        direccion_id bigint,
        primary key (id)
    )

    create table provincia (
        id varchar(255) not null,
        nombre varchar(255),
        pais_id varchar(255),
        primary key (id)
    )

    create table tipo_etiqueta (
        tipo_etiquetado varchar(31) not null,
        id bigint not null auto_increment,
        hashtag varchar(255),
        proveedor_id bigint,
        primary key (id)
    )

    create table usuario (
        id bigint not null auto_increment,
        nombre_usuario varchar(255),
        hash longblob,
        salt longblob,
        tipo_usuario varchar(255),
        organizacion_id bigint,
        primary key (id)
    )

    create table validaciones (
        tipo varchar(31) not null,
        id bigint not null auto_increment,
        primary key (id)
    )

    alter table ciudad 
        add constraint FK_nucuwpeey5l4e28qxcsonh5x4 
        foreign key (provincia_id) 
        references provincia (id)

    alter table comportamiento_categoria 
        add constraint FK_4mh7oqyaniihquh4uad87qlv1 
        foreign key (categoria_entidad_id) 
        references categoria_entidad (id)

    alter table entidad_base 
        add constraint FK_5s0txb3stuq8wx98baff6p65w 
        foreign key (categoria_id) 
        references categoria_entidad (id)

    alter table entidad_base 
        add constraint FK_jr7pdi7yiedcj06cgnhvg8q6g 
        foreign key (entidad_juridica_id) 
        references entidad_juridica (id)

    alter table entidad_juridica 
        add constraint FK_df2h2mfksqcobdbitdewfvp3u 
        foreign key (categoria_id) 
        references categoria_entidad (id)

    alter table entidad_juridica 
        add constraint FK_gvmqvurp3f63k6ctt6ejay723 
        foreign key (direccion_id) 
        references direccion (id)

    alter table entidad_juridica 
        add constraint FK_38u3nqvgg34lyfnk37qdjgf8r 
        foreign key (organizacion_id) 
        references organizacion (id)

    alter table etique_egreso_gastos 
        add constraint FK_glqljou4hbnnegitou6wg28w9 
        foreign key (moneda_id) 
        references moneda (id)

    alter table etique_egreso_gastos 
        add constraint FK_c5p6iejaq9aiqfhhv79jcyygw 
        foreign key (etiqueta_egreso_id) 
        references etiqueta_egreso (id)

    alter table etiqueta_egreso 
        add constraint FK_qw03cueeoqdfibl0scyhnxcfu 
        foreign key (tipo_etiqueta_id) 
        references tipo_etiqueta (id)

    alter table item 
        add constraint FK_7k6c00xja0vp5b5wconqlntyf 
        foreign key (operacion_de_egreso_id) 
        references operacion_de_egreso (id)

    alter table item 
        add constraint FK_gt6v66rwsv9kkmgbk4kni1mgr 
        foreign key (presupuesto_id) 
        references presupuesto (id)

    alter table item 
        add constraint FK_9wvfd1s4oer3eu7lq0hq6ct8p 
        foreign key (producto_id) 
        references producto (id)

    alter table mensaje 
        add constraint FK_lsdrjh2t3oepwr6667duwlrfg 
        foreign key (usuario_id) 
        references usuario (id)

    alter table operacion_de_egreso 
        add constraint FK_g3bm324rn9ydwwfpj5ixokl3i 
        foreign key (medios_de_pago_id) 
        references medios_de_pago (id)

    alter table operacion_de_egreso 
        add constraint FK_6y6xp4cbiajtau649ho1jops0 
        foreign key (moneda_id) 
        references moneda (id)

    alter table operacion_de_egreso 
        add constraint FK_ab3bg057u3s3g3hjprefrujc4 
        foreign key (proveedor_id) 
        references proveedor (id)

    alter table operacion_de_egreso 
        add constraint FK_plubo62003cyfnc899od2ku0e 
        foreign key (usuarioAlta_id) 
        references usuario (id)

    alter table operacion_de_egreso_etiqueta 
        add constraint FK_p8x51s1s3frp49ee0b1maf7kw 
        foreign key (operacion_id) 
        references operacion_de_egreso (id)

    alter table operacion_de_egreso_etiqueta 
        add constraint FK_4j30w52f3ow0y003btrxakg9n 
        foreign key (etiqueta_id) 
        references etiqueta_egreso (id)

    alter table operacion_de_egreso_usuario 
        add constraint FK_p71vyyoqx1kl5h882cnutlind 
        foreign key (operacion_id) 
        references operacion_de_egreso (id)

    alter table operacion_de_egreso_usuario 
        add constraint FK_ckpia6a8pfuosd76vk0ccqr74 
        foreign key (usuario_id) 
        references usuario (id)

    alter table presupuesto 
        add constraint FK_rsvpqkv2rpm6qgji3f5fr3vm0 
        foreign key (operacion_de_egreso_id) 
        references operacion_de_egreso (id)

    alter table presupuesto_tipo_documento 
        add constraint FK_ag20lfrujwbd341x4vut22bwb 
        foreign key (presupuesto_id) 
        references presupuesto (id)

    alter table proveedor 
        add constraint FK_353l9m4t3ita80ut3xnicgk8l 
        foreign key (direccion_id) 
        references direccion (id)

    alter table provincia 
        add constraint FK_pjwgt5adumuf6sgqsb0kkytae 
        foreign key (pais_id) 
        references pais (id)

    alter table tipo_etiqueta 
        add constraint FK_gp59k4jj5u8jckbgdqyom64st 
        foreign key (proveedor_id) 
        references proveedor (id)

    alter table usuario 
        add constraint FK_gnavyqa8r0tlfy9i6fsdsytw3 
        foreign key (organizacion_id) 
        references organizacion (id)

    create table hibernate_sequences (
         sequence_name varchar(255),
         sequence_next_hi_value integer 
    )
