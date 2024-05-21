package com.terry.demo.core.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKpMemberAuthority is a Querydsl query type for KpMemberAuthority
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKpMemberAuthority extends EntityPathBase<KpMemberAuthority> {

    private static final long serialVersionUID = -845786064L;

    public static final QKpMemberAuthority kpMemberAuthority = new QKpMemberAuthority("kpMemberAuthority");

    public final QKpBaseEntity _super = new QKpBaseEntity(this);

    public final StringPath authorityName = createString("authorityName");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    //inherited
    public final StringPath modId = _super.modId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public QKpMemberAuthority(String variable) {
        super(KpMemberAuthority.class, forVariable(variable));
    }

    public QKpMemberAuthority(Path<? extends KpMemberAuthority> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKpMemberAuthority(PathMetadata metadata) {
        super(KpMemberAuthority.class, metadata);
    }

}

