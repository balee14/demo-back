package com.terry.demo.core.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKpMemberToken is a Querydsl query type for KpMemberToken
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKpMemberToken extends EntityPathBase<KpMemberToken> {

    private static final long serialVersionUID = -1592359578L;

    public static final QKpMemberToken kpMemberToken = new QKpMemberToken("kpMemberToken");

    public final QKpBaseEntity _super = new QKpBaseEntity(this);

    public final StringPath accessToken = createString("accessToken");

    public final DateTimePath<java.time.LocalDateTime> accessTokenDt = createDateTime("accessTokenDt", java.time.LocalDateTime.class);

    public final StringPath idEmail = createString("idEmail");

    public final BooleanPath isUse = createBoolean("isUse");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    //inherited
    public final StringPath modId = _super.modId;

    public final StringPath refreshToken = createString("refreshToken");

    public final DateTimePath<java.time.LocalDateTime> refreshTokenDt = createDateTime("refreshTokenDt", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public final NumberPath<Long> tokenId = createNumber("tokenId", Long.class);

    public QKpMemberToken(String variable) {
        super(KpMemberToken.class, forVariable(variable));
    }

    public QKpMemberToken(Path<? extends KpMemberToken> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKpMemberToken(PathMetadata metadata) {
        super(KpMemberToken.class, metadata);
    }

}

