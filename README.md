# El TiempoES

![Demo](https://github.com/D4T0x/ElTiempoAPI/blob/main/Demo.gif)

El **TiempoEs** es una aplicación que nos permite ver la información del tiempo en las distintas provincias de España, tomando los datos de [el-tiempo.net](https://www.el-tiempo.net/api).

## Dependencias:

~~~java
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.google.code.gson:gson:2.8.6'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'io.reactivex.rxjava3:rxjava:3.0.0'
implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
implementation 'com.squareup.retrofit2:adapter-rxjava3:2.9.0'
~~~
- **Retrofit2:** Se encarga de realizar las peticiones HTTP.
- **GSON:** Se encarga de ***parsear*** el *.json* recibido.
- **Converter-GSON:** Enlace entre el *GSON* con *Retrofit*
- **RxJava:**  Extensión reactiva para java.
- **RxAndroid:** Extensión reactiva para android, permite el uso de operaciones asíncronas con el uso de objetos *Observable*
  - **AndroidSchedulers:** Permite el acceso al *MainThread*
- **Adapter-RxJava:** Enlace entre *RxJava* y *Retrofit*.

## API:

Se ha utilizado la API de la web [el-tiempo.net](https://www.el-tiempo.net/api), utilizando los siguientes *endpoints* :

- [/home](https://www.el-tiempo.net/api/json/v2/home)
    - Utilizando el método **GET**.
~~~json
{
   "title":"El Tiempo",
   "ciudades":[
      {
         "id":"08019",
         "idProvince":"08",
         "name":"Barcelona",
         "nameProvince":"Barcelona",
         "stateSky":{
            "description":"Poco nuboso",
            "id":"12"
         },
         "temperatures":{
            "max":"21",
            "min":"15"
         }
      },
      {
         "id":"28079",
         "idProvince":"28",
         "name":"Madrid",
         "nameProvince":"Madrid",
         "stateSky":{
            "description":"Poco nuboso",
            "id":"12"
         },
         "temperatures":{
            "max":"28",
            "min":"11"
         }
      },
      {
         "id":"41091",
         "idProvince":"41",
         "name":"Sevilla",
         "nameProvince":"Sevilla",
         "stateSky":{
            "description":"Poco nuboso",
            "id":"12"
         },
         "temperatures":{
            "max":"35",
            "min":"16"
         }
      },
      {
         "id":"46250",
         "idProvince":"46",
         "name":"Val\u00e8ncia",
         "nameProvince":"Valencia",
         "stateSky":{
            "description":"Nubes altas",
            "id":"17"
         },
         "temperatures":{
            "max":"24",
            "min":"15"
         }
      },
      {
         "id":"48020",
         "idProvince":"48",
         "name":"Bilbao",
         "nameProvince":"Bizkaia",
         "stateSky":{
            "description":"Nubes altas",
            "id":"17"
         },
         "temperatures":{
            "max":"25",
            "min":"8"
         }
      },
      {
         "id":"15030",
         "idProvince":"15",
         "name":"Coru\u00f1a, A",
         "nameProvince":"A Coru\u00f1a",
         "stateSky":{
            "description":"Muy nuboso con lluvia escasa",
            "id":"45"
         },
         "temperatures":{
            "max":"19",
            "min":"11"
         }
      }
   ],
   "today":{
      "p":[
         "En casi todo el pa\u00eds se espera que contin\u00fae predominando el tiempo estable con cielos poco nubosos con nubes altas y nubosidad de evoluci\u00f3n dispersa en zonas monta\u00f1osas. Tambi\u00e9n habr\u00e1 intervalos de nubes bajas en la primera mitad del d\u00eda en el Estrecho y Melilla. Posibilidad de lluvias d\u00e9biles y alg\u00fan chubasco a primeras horas en el noreste de Catalu\u00f1a. Al final del d\u00eda, habr\u00e1 un aumento de la nubosidad en el noroeste de Galicia, con baja probabilidad de precipitaciones d\u00e9biles por la aproximaci\u00f3n de un sistema frontal poco activo. ",
         "Temperaturas diurnas en aumento casi generalizado, excepto en el sur de Andaluc\u00eda, Estrecho y sureste peninsular donde habr\u00e1 un descenso. El ascenso ser\u00e1 notable en Canarias orientales y en zonas de la mitad norte peninsular. Se alcanzar\u00e1n valores superiores a los habituales en Canarias y el suroeste peninsular, super\u00e1ndose los 34 grados en el bajo Guadalquivir.",
         "Vientos de componente este en el \u00e1rea mediterr\u00e1nea, con levante fuerte en el Estrecho. Norte rolando a sudoeste en Ampurd\u00e1n y Menorca. Variables rolando a componente oeste en el Cant\u00e1brico. Alisios con rachas fuertes o muy fuertes en Canarias, especialmente en las islas monta\u00f1osas."
      ]
   },
   "tomorrow":{
      "p":[
         "En gran parte de la mitad sur peninsular, \u00e1rea mediterr\u00e1nea y zona centro se espera que predominen cielos poco nubosos o con nubes altas. No obstante, un frente atl\u00e1ntico poco activo atravesar\u00e1 el extremo norte de oeste a este, dejando cielos nubosos y lluvias, d\u00e9biles en general, en Galicia y el Cant\u00e1brico y en forma de chubascos ocasionales en zonas monta\u00f1osas y en Pirineos. Intervalos nubosos y nubosidad de evoluci\u00f3n en gran parte del tercio norte peninsular, con baja probabilidad de precipitaciones dispersas, tendiendo a remitir en todas las zonas a lo largo del d\u00eda. ",
         "Posibles nubes bajas matinales en el Estrecho y Melilla, as\u00ed como brumas en el extremo norte y calima alta en islas orientales de Canarias. ",
         "Temperaturas diurnas en descenso en la mitad noroeste peninsular, notable en el interior de Galicia y del Cant\u00e1brico, y en aumento en el \u00e1rea mediterr\u00e1nea, sur peninsular y Canarias. Se alcanzar\u00e1n valores superiores a los habituales en Canarias, Andaluc\u00eda y zonas del interior oriental peninsular, super\u00e1ndose los 34 grados en el bajo Guadalquivir y localmente en otras zonas del interior sur. Las m\u00ednimas, en acusado ascenso en el noreste de la Pen\u00ednsula.",
         "El viento soplar\u00e1 de componente este en el sur del \u00e1rea mediterr\u00e1nea, con intervalos de levante fuerte en el Estrecho en la primera mitad del d\u00eda. En el resto del \u00e1rea mediterr\u00e1nea, predominio de la componente sur. De componente oeste en la vertiente atl\u00e1ntica, m\u00e1s intenso en el entorno del alto Ebro y zonas del norte de Castilla y Le\u00f3n. Alisio en Canarias, con rachas fuertes o muy fuertes en las islas monta\u00f1osas."
      ]
   },
   "provincias":[
      {
         "CODPROV":"01",
         "NOMBRE_PROVINCIA":"Araba\/\u00c1lava",
         "CODAUTON":"16",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Pa\u00eds Vasco\/Euskadi",
         "CAPITAL_PROVINCIA":"Vitoria-Gasteiz"
      },
      {
         "CODPROV":"02",
         "NOMBRE_PROVINCIA":"Albacete",
         "CODAUTON":"08",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Castilla-La Mancha",
         "CAPITAL_PROVINCIA":"Albacete"
      },
      {
         "CODPROV":"03",
         "NOMBRE_PROVINCIA":"Alacant\/Alicante",
         "CODAUTON":"10",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Comunitat Valenciana",
         "CAPITAL_PROVINCIA":"Alicante\/Alacant"
      },
      {
         "CODPROV":"04",
         "NOMBRE_PROVINCIA":"Almer\u00eda",
         "CODAUTON":"01",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Andaluc\u00eda",
         "CAPITAL_PROVINCIA":"Almer\u00eda"
      },
      {
         "CODPROV":"05",
         "NOMBRE_PROVINCIA":"\u00c1vila",
         "CODAUTON":"07",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Castilla y Le\u00f3n",
         "CAPITAL_PROVINCIA":"\u00c1vila"
      },
      {
         "CODPROV":"06",
         "NOMBRE_PROVINCIA":"Badajoz",
         "CODAUTON":"11",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Extremadura",
         "CAPITAL_PROVINCIA":"Badajoz"
      },
      {
         "CODPROV":"07",
         "NOMBRE_PROVINCIA":"Illes Balears",
         "CODAUTON":"04",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Illes Balears",
         "CAPITAL_PROVINCIA":"Palma de Mallorca"
      },
      {
         "CODPROV":"08",
         "NOMBRE_PROVINCIA":"Barcelona",
         "CODAUTON":"09",
         "COMUNIDAD_CIUDAD_AUTONOMA":"Catalu\u00f1a\/Catalunya",
         "CAPITAL_PROVINCIA":"Barcelona"
      }
   ],
   "breadcrumb":[
      
   ],
   "metadescripcion":"El tiempo | La previsi\u00f3n meteorol\u00f3gica diaria de provincias y municipios de Espa\u00f1a",
   "keywords":"Previsi\u00f3n, meteorol\u00f3gica, tiempo, Espa\u00f1a, municipios, previsi\u00f3n del tiempo, previsi\u00f3n meteorol\u00f3gica"
}
~~~
> Este JSON ha sido recortado para no ocupar mucho espacio en el documento, si quiere ver el JSON completo siga el enlace.

- [/provincias/{CODPROV}](https://www.el-tiempo.net/api/json/v2/provincias/[CODPROV])
    - Utilizandoel método **GET** y enviando el parámetro **CODPROV** que es adquirido mediante la llamada al primer *endpoint*. 
~~~json
{
   "title":"El tiempo en la provincia de Araba\/\u00c1lava",
   "today":{
      "p":"Poco nuboso con intervalos de nubes altas y, al principio, intervalos de nubes bajas, brumas y alg\u00fan banco de niebla matinal. Temperaturas m\u00ednimas en descenso ligero y m\u00e1ximas en ascenso notable. Viento flojo variable con predominio del sur por la ma\u00f1ana."
   },
   "tomorrow":{
      "p":"Nuboso en el extremo norte e intervalos nubosos en el resto aumentando a nuboso o cubierto por la tarde, cuando se esperan precipitaciones d\u00e9biles, poco probables en el sureste y m\u00e1s intensas en el extremo noroeste, tendiendo a remitir al final. Temperaturas m\u00ednimas, que se esperan al final del d\u00eda, en ascenso, y m\u00e1ximas en descenso que ser\u00e1 notable en el extremo norte. Viento flojo del norte con intervalos m\u00e1s intensos en la mitad sur por la tarde."
   },
   "ciudades":[
      {
         "id":"01059",
         "idProvince":"01",
         "name":"Vitoria-Gasteiz",
         "nameProvince":"\u00c1lava",
         "stateSky":{
            "description":"Nubes altas",
            "id":"17"
         },
         "temperatures":{
            "max":"25",
            "min":"5"
         }
      },
      {
         "id":"01031",
         "idProvince":"01",
         "name":"Laguardia",
         "nameProvince":"\u00c1lava",
         "stateSky":{
            "description":"Nubes altas",
            "id":"17"
         },
         "temperatures":{
            "max":"25",
            "min":"7"
         }
      },
      {
         "id":"01036",
         "idProvince":"01",
         "name":"Laudio",
         "nameProvince":"\u00c1lava",
         "stateSky":{
            "description":"Nubes altas",
            "id":"17"
         },
         "temperatures":{
            "max":"26",
            "min":"7"
         }
      }
   ],
   "provincia":{
      "CODPROV":"01",
      "NOMBRE_PROVINCIA":"Araba\/\u00c1lava",
      "CODAUTON":"16",
      "COMUNIDAD_CIUDAD_AUTONOMA":"Pa\u00eds Vasco\/Euskadi",
      "CAPITAL_PROVINCIA":"Vitoria-Gasteiz"
   },
   "comautonoma":{
      "ID":"pva",
      "CODAUTON":"16",
      "CODCOMUN":"75",
      "NOMBRE":"PA\u00cdS VASCO"
   },
   "breadcrumb":[
      {
         "name":"Provincias",
         "url":"\/provincias",
         "title":"El tiempo | Lista de provincias"
      },
      {
         "name":"\u00c1lava",
         "url":null,
         "title":"El tiempo en la provincia de Araba\/\u00c1lava"
      }
   ],
   "metadescripcion":"El tiempo en la provincia de Araba\/\u00c1lava",
   "keywords":"El tiempo en la provincia de Araba\/\u00c1lava, precipitaciones, viento, lluvia, estado del cielo"
}
~~~

Para pasar el *.json* a clases se ha utilizado la web [jsonschema2pojo](https://www.jsonschema2pojo.org/). 

### elTiempoAPI Servicio Retrofit

Se ha definido una clase que utiliza el patrón *Singelton* para generar una instancia del servicio de ***Retrofit2***, utilizando ***Gson*** como *converter* y  ***RxJava*** para definir el *Adapter*:

~~~java
public class eltiempoAPI {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.el-tiempo.net/api/json/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    private static Eltiempo service = retrofit.create(Eltiempo.class);

    public static synchronized Eltiempo getInstance() {
        if (service == null)
            service = retrofit.create(Eltiempo.class);
        return service;
    }
}
~~~



## La interfaz Retrofit:

~~~java
public interface Eltiempo {
    @GET("home")
    Observable <Example> getHome();

    @GET("provincias/{CODPROV}")
    Observable <ExampleProv> getProv(@Path("CODPROV") String CODPROV);
}
~~~
Se utiliza para realizar las llamadas HTTP a la API, cómo podemos observar se implementan los dos *endpoints* mencionados y la clase *Observable*.

## IU:
Se han definido dos *fragments* para gestionar la interfaz

### Fragment Lista de provincias:
Se ha definido un ***RecyclerView*** utilizando el patrón ***ViewHolder*** para que no se realicen tantas llamadas a la API y los datos queden guardados en la lista.
~~~xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".fragments.FragmentListaProvincias">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/listaProvincias"
        android:layout_width="409dp"
        android:layout_height="729dp"
         />
</FrameLayout>
~~~
~~~java
public class FragmentListaProvincias extends Fragment {

    private List<Provincia> datos = new ArrayList<>();
    private EltiempoAdapter adapter;
    private RecyclerView recyclerProvincias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_lista_provincias, container, false);

        datos = new ArrayList<>();
        adapter = new EltiempoAdapter(datos);
        recyclerProvincias = vista.findViewById(R.id.listaProvincias);
        recyclerProvincias.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerProvincias.setAdapter(adapter);
        downloadData();

        return vista;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void downloadData(){
        eltiempoAPI.getInstance()
                .getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable(x -> x.getProvincias())
                .map(x -> datos.add(x))
                .subscribe( x -> adapter.notifyDataSetChanged());
    }
}
~~~
Como se puede ver en el código `private EltiempoAdapter adapter;` se utiliza una clase que funciona como *adapter* e implementa el patón ***ViewHolder***:

~~~java
public class EltiempoAdapter extends RecyclerView.Adapter<EltiempoAdapter.ViewHolder> {
    private List<Provincia> datos;

    public EltiempoAdapter(List<Provincia> datos){
        this.datos = datos;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(mview);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.provincia.setText(datos.get(position).getNombreProvincia());
        holder.provincia.setId(Integer.parseInt(datos.get(position).getCodprov()));

    }
    @Override
    public int getItemCount() {
        return datos.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView provincia;
        private Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.provincia);
            provincia = itemView.findViewById(R.id.provincia);
        }
    }
}
~~~

Esta clase utiliza el *layout* ***Row*** (`View mview = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);`) que implementa un Botón:
~~~xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <Button
        android:id="@+id/provincia"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        style="?android:attr/borderlessButtonStyle"
        android:textColor="@color/black"
        android:textStyle="bold"
        android:onClick="onClick"
        />
</RelativeLayout>
~~~
### Fragment Detalles de provincias:
~~~java 
public class FragmentDetallesProvincia extends Fragment {

    private List<Provincia> datos;


    public FragmentDetallesProvincia() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        scroller.addView(text);
        downloadData(text);
        return scroller;

    }

    private void downloadData(TextView text) {
        eltiempoAPI.getInstance()
                .getProv(MainActivity.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(x -> text.setText(x.getTitle()+
                        "\n\nHoy:\n"+x.getToday().getP()+
                        "\n\nMañana:\n"+x.getToday().getP()+
                        "\n\n"+imprimeCiudades(x.getCiudades())
                ));
    }

    private String imprimeCiudades(List<Ciudade> ciudades) {
        String a = "";
        for (Ciudade c:ciudades) {
            a += "\n"+c.getName()+
                    "\n"+c.getStateSky().getDescription()+
                    "\nT.Max: "+c.getTemperatures().getMax()+
                    "\nT.Min: "+c.getTemperatures().getMin()+
                    "\n\n";
        }
        return a;
    }
}
~~~

Podemos observar que en ambas existe la función ` downloadData();`, esta función genera la petición *Retrofit* e introduce los datos en la variable *datos* para poder manipularlos posteriormente.

## Main activity:

~~~xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/contenedorFragments"
        ></FrameLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
~~~
```java
public class MainActivity extends AppCompatActivity {
    public static String id;
    private List<Provincia> datos = new ArrayList<>();
    private EltiempoAdapter adapter;

    FragmentTransaction transaction;
    Fragment fragmentListaProvincias, fragmentDetallesProvincia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentListaProvincias = new FragmentListaProvincias();
        fragmentDetallesProvincia = new FragmentDetallesProvincia();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments, fragmentListaProvincias).commit();
    }

    public void onClick(View view){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorFragments, fragmentDetallesProvincia).commit();
        transaction.addToBackStack(null);
        String a = Integer.toString(view.getId());
        if(a.length()==1){
            id = "0"+a;
        }else id = a;
    }
}
```
Se ha utilizado el método *OnClick* para gestionar la transacción entre vistas, *parseando* el numero entero a el valor necesario para que la API responda.

El *fragment* que se ha definido por defecto es la presentación del *RecycledView* de botones con el nombre de las provincias, pudiendo regresar a el desde el otro *fragment* tan solo con pulsar el botón atrás.

## Mejoras a implementar:

- [ ] Mejorar interfaz de usuario para ser más amigable.
- [ ] Animación de carga mientras se espera a la presentación de los datos.
- [ ] Insertar imágenes que correspondan al tiempo que hay en la provincia seleccionada. 
------

Los datos utilizados son propiedad de ©AEMET (Agencia Estatal de Meteorología).

------

Enrique Sanz | enrique.sanz.gil@alumnos.upm.es
