# Template Esame ISPW

## Descrizione

Il template permette di creare un'applicazione con JavaFx, effettuare code coverage ed effettuare test con Selenium.
La configurazione delle dipendenze è gestita da Gradle e non è necessario aggiungere file al classpath, installare driver o sciocchezze simili. 

## Guida d'uso

- Forka questo template
- Crea una nuova repository e setta come template la repository forkata
- Aggiorna il file settings.gradle con il nome della repository (il nome di default è EsameISPW)
- Importa il progetto su Eclipse selezionando File>Import>Gradle>Existing Gradle Project
- Esegui il task gradle ide>eclipse
- Premi il tasto destro sulla cartella importata nel Project Explorer e seleziona Refresh
- Se è necessario analizzare la repository con SonarCloud aggiungi il SONAR_TOKEN e decommenta le linee indicate nel file .github/workflows/build.yml
- Per eseguire eventualmente debug delle github action decommenta il task *tmate session* e dopo aver riavviato il workflow apri una connessione ssh verso l'host iondicato.
- Profit?
