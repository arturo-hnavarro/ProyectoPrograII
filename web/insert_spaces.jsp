<%@page import="Domain.Space"%>
<%@page import="Domain.ParkingLot"%>
<%@page import="Domain.VehicleType"%>
<!doctype html>
<html>
    <head>
        <title>parqueos oso polar - Espacios</title>
        <%
            int numberOfSpaces = Integer.parseInt(request.getParameter("numberOfSpaces"));
            int numberOfSpacesDisabilityPresented = Integer.parseInt(request.getParameter("numberOfSpacesDisabilityPresented"));
            Space[] spaces = new Space[numberOfSpaces];
        %>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0" />
        <link href="//fonts.googleapis.com/css?family=Exo+2:300,500,600,regular,italic&subset=latin,latin-ext,cyrillic" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/designs/_shared/css/layout-shared.css?v=1.241" type="text/css" />
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/designs/_shared/css/menu-bones.css?v=1.241" type="text/css" />
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/layout.css?v=1.241" type="text/css" />
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/editable.css?v=1.241" type="text/css" />
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/animation.css?v=1.241" type="text/css" />
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/theme-stripe.css?v=1.241" type="text/css" />
        <link href="https://dss4hwpyv4qfp.cloudfront.net/mozello.ico" rel="shortcut icon">
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/backend/css/backend.css?v=1.241" type="text/css" />
        <link rel="stylesheet" href="https://dss4hwpyv4qfp.cloudfront.net/libs/js/fancybox/jquery.fancybox.css?v=1.241" type="text/css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="https://dss4hwpyv4qfp.cloudfront.net/cache/preview-es.1.241.js"></script>

        <style class="customizer">
            #title { background-color :  #05679b  }
            #title:after { border-top-color :  #05679b  }
            #title .mz_wysiwyg { color :  #ffffff  }
            #menu > ul > li > a { color :  #ffffff  }
            #menu > ul > li.selected > a, #menu > ul > li > a:hover { color :  #0088d1  }
            #bigbar-colorizer { background-color :  hsla(0, 0%, 0%, 0.5)  }
            #languages li > a { color :  #ffffff  }
            #languages li > a.selected, #languages li > a:hover { background-color :  #05679b  }
            #languages li > a.selected, #languages li > a:hover { color :  #ffffff  }
            a, .mz_editable a { color :  #0088d1  }
            a:hover, .mz_editable a:hover, .mz_recentposts a:hover { color :  #05679b  }
            .moze-form .moze-formbutton, .moze-button, .moze-button-large, ul.moze-gallery li, #submenu li:hover a, #submenu li.selected a { background-color :  #05679b  }
            .moze-form .moze-formbutton:hover, .moze-button:hover, .moze-button-large:hover { background-color :  #a0a0a0  }
            .mz_editable h1, .mz_editable h1.moze-megatitle, .mz_editable h1 a { color :  #444444  }
            .mz_editable h2, .sidebox h2 { color :  #444444  }
            .mz_editable h3 { color :  #444444  }
            body { background-color :  #05679b  }
            #bottom .mz_editable { color :  #a3dfff  }
            #bottom a { color :  #ffffff  }
            #bottom a:hover { color :  #a3dfff  }
        </style>
        <style class="customizer-fonts"></style>
        <script src="https://dss4hwpyv4qfp.cloudfront.net/designs/impress/js/main.js"></script>
        <script>
            // resize banner
            function InitLayout() {
                //var setHeight = $("#bigbar").outerHeight();
                //$('#bigbar>div.mz_banner').css("min-height", setHeight);
            }
            $(document).ready(function () {
                // Resize on window size
                $(window).resize(function () {
                    InitLayout();
                });
                // Resize on key up
                $("#bigbar").keyup(function () {
                    InitLayout();
                });
                // Resize on load
                InitLayout();
            });
        </script>
    </head>

    <body class="" lang="es">               
        <div id="top">
            <div id="header">
                <div id="title">
                    <div class="mz_component mz_wysiwyg mz_editable">
                        <div class="moze-wysiwyg-editor moze-no-select-border" >
                            parqueos oso polar
                        </div>
                    </div>
                </div>
                <div class="mz_component mz_menu" id="menu">
                    <ul>
                        <li><a href="/" >Inicio</a>
                        </li>
                        <li><a href="/servicios/" >Parqueos</a>
                            <ul>
                                <li><a href="/servicios/ingresar/" >Ingresar</a></li>
                                <li><a href="/servicios/consultar/" >Consultar</a></li>
                                <li><a href="/servicios/modificar/" >Modificar</a></li>
                                <li><a href="/servicios/eliminar/" >Eliminar</a></li>
                            </ul></li>
                        <li><a href="/trabajos/" >Clientes</a>
                            <ul>
                                <li><a href="/trabajos/agregar/" >Agregar</a></li>
                                <li><a href="/trabajos/consultar/" >Consultar</a></li>
                                <li><a href="/trabajos/eliminar/" >Eliminar</a></li>
                                <li><a href="/trabajos/modificar/" >Modificar</a></li>
                            </ul></li>
                        <li><a href="/sobre-mi/" >Vehiculos</a>
                            <ul>
                                <li><a href="/sobre-mi/consular/" >Consular</a></li>
                            </ul></li>
                        <li><a href="/precios/" >Precios</a>
                            <ul>
                                <li><a href="/precios/consular_modificar/" >Consultar y modificar</a></li>
                            </ul></li>
                        <li><a href="/contacto/" >Contacto</a>
                            <ul>
                                <li><a href="/contacto/tarifas/" >Tarifas</a></li>
                            </ul></li>
                        <li class="selected"><a href="/pagina/" >Espacios</a>
                        </li></ul>
                </div>
                <br style="clear: both"/>
            </div>
        </div>
        <div id="belowfold">

            <div id="wrap">
                <div class="mz_component mz_menu" id="submenu"></div>
                <div class="mz_component mz_grid" data-cid="11169221" data-pid="2593015">
                    <div class="section section-customizable" data-rowid="1270392">
                        <div class="container">
                            <div class="gridrow">
                                <div class="column-12-12" data-cellid="1673295">
                                    <div class="mz_component mz_wysiwyg mz_editable">
                                        <div class="moze-wysiwyg-editor moze-no-select-border" >
                                            <p></p>
                                            <table class="moze-table-border">
                                                <tbody>
                                                    <tr class="moze-th">
                                                        <td style="text-align: center;"><b>Numero de espacio<b></b></td>
                                                        <td style="text-align: center;"><b>Discapacidad presente<b></b></td>
                                                        <td style="text-align: center;"><b>Estado</b></td>
                                                        <td style="text-align: center;"><b>Tipo de vehículo<b></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <%for (int x = 1; x <= numberOfSpaces; x++) {;%>
                                                                    <tr>
                                                                        <td style="text-align: center;"> <%=x%> </td>
                                                                        <td style="text-align: center;"><% if (x <= numberOfSpacesDisabilityPresented) {;%>
                                                                            Si <%} else {;%>
                                                                            No <%};%>
                                                                        </td>
                                                                        <td style="text-align: center;"> Disponible</td>
                                                                        <td style="text-align: center;"> 

                                                                            <div  id="VehicleTypeHolder" >
                                                                                <select  id="VehicleType" name="VehicleType" >
                                                                                    <option value="">Selecciona</option>
                                                                                    <option  value="Automovil" >Automovil</option>
                                                                                    <option  value="Moto" >Moto</option>
                                                                                    <option  value="Bicicleta" >Bicicleta</option>
                                                                                    <option  value="Camion" >Camión</option>
                                                                                </select>
                                                                            </div></td>
                                                                            <%};%>
                                                                    </tr>
                                                                    </tbody>
                                                                    
                                                                    </table>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    <div id="bottom">
                                                                        <div class="mz_component mz_wysiwyg mz_editable">    
                                                                            <div class="moze-wysiwyg-editor moze-no-select-border" >Proyecto programación 2 - UCR 2017</div>
                                                                        </div>
                                                                    </div>
                                                                    </div>
                                                                    </body>
                                                                    </html>