package com.terry.demo.core.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKpTest is a Querydsl query type for KpTest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKpTest extends EntityPathBase<KpTest> {

    private static final long serialVersionUID = 1065833611L;

    public static final QKpTest kpTest = new QKpTest("kpTest");

    public final QKpBaseEntity _super = new QKpBaseEntity(this);

    public final StringPath idEmail = createString("idEmail");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    //inherited
    public final StringPath modId = _super.modId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public final NumberPath<Long> testId = createNumber("testId", Long.class);

    public QKpTest(String variable) {
        super(KpTest.class, forVariable(variable));
    }

    public QKpTest(Path<? extends KpTest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKpTest(PathMetadata metadata) {
        super(KpTest.class, metadata);
    }

}

