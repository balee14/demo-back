package com.terry.demo.core.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QKpMember is a Querydsl query type for KpMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKpMember extends EntityPathBase<KpMember> {

    private static final long serialVersionUID = 1863286867L;

    public static final QKpMember kpMember = new QKpMember("kpMember");

    public final QKpBaseEntity _super = new QKpBaseEntity(this);

    public final SetPath<KpAuthority, QKpAuthority> authorities = this.<KpAuthority, QKpAuthority>createSet("authorities", KpAuthority.class, QKpAuthority.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath idEmail = createString("idEmail");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    //inherited
    public final StringPath modId = _super.modId;

    public final StringPath name = createString("name");

    public final StringPath pwd = createString("pwd");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public final EnumPath<com.terry.demo.core.enumeration.MemberStateEnum> state = createEnum("state", com.terry.demo.core.enumeration.MemberStateEnum.class);

    public final StringPath telephone = createString("telephone");

    public QKpMember(String variable) {
        super(KpMember.class, forVariable(variable));
    }

    public QKpMember(Path<? extends KpMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKpMember(PathMetadata metadata) {
        super(KpMember.class, metadata);
    }

}

