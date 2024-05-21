package com.terry.demo.core.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKpAuthority is a Querydsl query type for KpAuthority
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKpAuthority extends EntityPathBase<KpAuthority> {

    private static final long serialVersionUID = 1155205866L;

    public static final QKpAuthority kpAuthority = new QKpAuthority("kpAuthority");

    public final QKpBaseEntity _super = new QKpBaseEntity(this);

    public final StringPath authorityName = createString("authorityName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    //inherited
    public final StringPath modId = _super.modId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public QKpAuthority(String variable) {
        super(KpAuthority.class, forVariable(variable));
    }

    public QKpAuthority(Path<? extends KpAuthority> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKpAuthority(PathMetadata metadata) {
        super(KpAuthority.class, metadata);
    }

}

