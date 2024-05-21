package com.terry.demo.core.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKpBaseEntity is a Querydsl query type for KpBaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QKpBaseEntity extends EntityPathBase<KpBaseEntity> {

    private static final long serialVersionUID = 1728325453L;

    public static final QKpBaseEntity kpBaseEntity = new QKpBaseEntity("kpBaseEntity");

    public final DateTimePath<java.time.LocalDateTime> modDt = createDateTime("modDt", java.time.LocalDateTime.class);

    public final StringPath modId = createString("modId");

    public final DateTimePath<java.time.LocalDateTime> regDt = createDateTime("regDt", java.time.LocalDateTime.class);

    public final StringPath regId = createString("regId");

    public QKpBaseEntity(String variable) {
        super(KpBaseEntity.class, forVariable(variable));
    }

    public QKpBaseEntity(Path<? extends KpBaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKpBaseEntity(PathMetadata metadata) {
        super(KpBaseEntity.class, metadata);
    }

}

