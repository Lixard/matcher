for COUNTER in {1..120}
do
   sleep 1s
   echo "check db $COUNTER times"
   pg_isready
   if [ $? -eq 0 ]
   then
     break
   fi
done

echo "try execute liquibase"
bash liquibase/liquibase --url="jdbc:postgresql://localhost:5432/$POSTGRES_DB"  --username=$POSTGRES_USER \
 --password=$POSTGRES_PASSWORD --changeLogFile=/liquibase/changelog/master-changelog.yml update
