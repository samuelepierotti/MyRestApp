# MyRestApp

MyRestApp è un'applicazione Android distribuita sviluppata in Kotlin, che consente, previa autenticazione, di accedere a servizi interni ed esterni.

## Funzionalità

L'app permette di:

- **Autenticarsi** tramite credenziali predefinite.
- **Cercare informazioni su film** inserendo il titolo, sfruttando l'API OMDb.
- **Visualizzare i risultati** in formato dinamico con un layout strutturato.
- **Collegarsi a un sito web** tramite una WebView interna.

## Login

La schermata di accesso (`MainActivity`) consente l'autenticazione usando coppie di credenziali hardcoded (a scopo dimostrativo):

- `User1` / `1234`
- `User2` / `0000`
- `User3` / `9876`

Dopo l'autenticazione, si accede alla `MenuActivity`.

## Navigazione e Activity

### 1. **MainActivity**
- Prima schermata dell'app.
- Gestisce il login.
- Rimanda alla `MenuActivity` in caso di credenziali corrette.

### 2. **MenuActivity**
- Schermata di menu principale accessibile dopo il login.
- Contiene tre pulsanti per accedere alle varie funzionalità:
  - **Search** → accede a `SearchActivity`
  - **WebView** → accede a `WebViewActivity`
  - **Rest** → accede a `RestActivity` (non implementata)

### 3. **SearchActivity**
- Permette la ricerca di film inserendo il titolo, utilizzando l’API OMDb.
- Utilizza Volley per eseguire richieste HTTP e Gson per il parsing del JSON.
- I risultati vengono mostrati in una RecyclerView grazie a `MovieAdapter`.

### 4. **WebViewActivity**
- Apre la pagina web di IMDb con il browser predefinito del dispositivo.

### 5. **RestActivity**
- Attualmente non implementata.

## Risorse esterne

Le immagini mostrate nella Main e Search activity sono inclusa nella cartella `res/drawable`.
