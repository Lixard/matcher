FROM liquibase/liquibase:4.1 AS Liquibase

FROM postgres:12 AS Postgres

EXPOSE 5432

ENV POSTGRES_DB matcher
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 123


COPY --from=Liquibase /liquibase /liquibase

ENV JAVA_HOME /usr/local/openjdk-11
COPY --from=Liquibase $JAVA_HOME $JAVA_HOME


ENV LIQUIBASE_CHANGELOG /liquibase/changelog/
COPY /changesets $LIQUIBASE_CHANGELOG


COPY liquibase.sh /usr/local/bin/
COPY main.sh /usr/local/bin/

RUN chmod +x /usr/local/bin/liquibase.sh && \
    chmod +x /usr/local/bin/main.sh && \
    ln -s /usr/local/bin/main.sh / && \
    ln -s /usr/local/bin/liquibase.sh /

ENTRYPOINT ["main.sh"]
