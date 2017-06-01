<%-- 
    Document   : show_vehicle_registered_in_parkingLot
    Created on : 31/05/2017, 08:47:27 AM
    Author     : Arturo
--%>

<!doctype html>

<html>
    <head>
        <title>parqueos oso polar - Agregar</title>

        <%
            String spaceGiven = response.getHeader("spaceGiven");
            String parkingLotName = response.getHeader("parkingLotName");

            //Vehicle info
            String plate = response.getHeader("plate");
            String color = response.getHeader("color");
            String brand = response.getHeader("brand");
            String model = response.getHeader("model");
            String comments = response.getHeader("comments");
            String vehicleTypeId = response.getHeader("vehicleTypeId");

            //Customer info
            String identification = response.getHeader("identification");
            String name = response.getHeader("name");
            String username = response.getHeader("username");
            String disabilityPresented = response.getHeader("disabilityPresented");
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
        <style class="customizer-fonts">
        </style>
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
                <div id="languages">
                </div>
                <div id="title">
                    <div class="mz_component mz_wysiwyg mz_editable">    <div class="moze-wysiwyg-editor moze-no-select-border" >
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
                                <li><a href="/servicios/ingresar/" >Ingresar</a>
                                </li>
                                <li><a href="/servicios/consultar/" >Consultar</a>
                                </li>
                                <li><a href="/servicios/modificar/" >Modificar</a>
                                </li>
                                <li><a href="/servicios/eliminar/" >Eliminar</a>
                                </li>
                            </ul></li>
                        <li ><a href="/trabajos/" >Clientes</a>
                            <ul>
                                <li><a href="/trabajos/agregar/" >Agregar</a>
                                </li>
                                <li><a href="/trabajos/consultar/" >Consultar</a>
                                </li>
                                <li><a href="/trabajos/eliminar/" >Eliminar</a>
                                </li>
                                <li><a href="/trabajos/modificar/" >Modificar</a>
                                </li>
                            </ul></li>
                        <li class="selected"><a href="/sobre-mi/" >Vehiculos</a>
                            <ul>
                                <li><a href="/sobre-mi/consular/" >Consular</a>
                                </li>
                                <li class="selected"><a href="/sobre-mi/registrar-en-parqueo/" >Registrar en parqueo</a>
                                </li>
                            </ul></li>
                        <li><a href="/precios/" >Precios</a>
                            <ul>
                                <li><a href="/precios/consular_modificar/" >Consultar y modificar</a>
                                </li>
                            </ul></li>
                        <li><a href="/contacto/" >Contacto</a>
                            <ul>
                                <li><a href="/contacto/tarifas/" >Tarifas</a>
                                </li>
                            </ul></li>
                        <li><a href="/spaces/" >Espacios</a>
                        </li></ul>
                </div>
                <br style="clear: both"/>
            </div>
        </div>
        <div id="belowfold">
            <div id="wrap">
                <div class="mz_component mz_menu" id="submenu">
                    <ul>
                        <li class="selected"><a href="/trabajos/agregar/" >Agregar</a>
                        </li>
                        <li><a href="/trabajos/consultar/" >Consultar</a>
                        </li>
                        <li><a href="/trabajos/eliminar/" >Eliminar</a>
                        </li>
                        <li><a href="/trabajos/modificar/" >Modificar</a>
                        </li></ul>

                </div>
                <script>

                    var webformFx = function (form) {

                        this.gatherData = function ()
                        {
                            var result = {};
                            $(form).find('[name^="moze-webform-ctrl-"]').each(function () {
                                if ($(this).attr('type') == 'checkbox') {
                                    result[$(this).attr('name')] = $(this).is(':checked') ? 1 : 0;
                                } else {
                                    result[$(this).attr('name')] = $.trim($(this).val());
                                }
                            });
                            return result;
                        };

                        this.validateForm = function ()
                        {
                            var requiredCtrls = form.find('[data-required]');
                            var result = true;

                            requiredCtrls.removeClass('moze-formerror');

                            $.each(requiredCtrls, function () {

                                var subresult;
                                var validator = $(this).data('required');

                                switch (validator) {

                                    case 'textbox':
                                        subresult = $(this).val() !== '';
                                        break;

                                    case 'multiline':
                                        subresult = $(this).val() !== '';
                                        break;

                                    case 'checkbox':
                                        subresult = $(this).is(':checked');
                                        break;

                                    case 'combobox':
                                        subresult = $(this).val() !== '';
                                        break;

                                    case 'email':
                                        subresult = $.trim($(this).val()).match(/^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$/i) !== null;
                                        break;
                                }

                                if (subresult === false) {
                                    $(this).addClass('moze-formerror');
                                }
                                result = result && subresult;

                            });

                            return result;
                        };

                        if (this.validateForm())
                        {
                            var componentID = $(form).parent('div.mz_form').data('cid');

                            mozLive({
                                src: {id: componentID},
                                dest: null,
                                action: 'webform-submit',
                                task: 'redirect',
                                parameters: {
                                    data: this.gatherData(),
                                    href: '/trabajos/agregar/params/submitted/' + componentID + '/'
                                },
                                errors: {
                                    maintenance: 'No podemos procesar tu solicitud en este momento. Intenta de nuevo más tarde.'
                                }
                            });
                        } else
                        {
                            alert($(form).data('failuremsg'));
                        }
                        return false;
                    };
                </script>
                <div class="mz_component mz_grid" data-cid="11084944" data-pid="2572129">
                    <div class="section section-customizable" data-rowid="1290593">
                        <div class="container">
                            <div class="gridrow">
                                <div class="column-8-12" data-cellid="1699545">
                                    <div id="editable">
                                        <div class="mz_component mz_wysiwyg mz_editable">
                                            <div class="moze-wysiwyg-editor moze-no-select-border" >
                                                <h1>Registrar vehículo</h1>
                                                <p>Proceso completado. Información del registro. </p>
                                                <span class="moze-important">
                                                    <label style="color: #0088d1" ><b>Espacio asignado: </b>   <i><%=spaceGiven%></i> </label><br />
                                                    <label style="color: #0088d1"><b>Parqueo correspondiente:</b>   <i><%=parkingLotName%></i> <br></label><br />
                                                </span>
                                                <span class="moze-important"><label><b>Información del vehículo</b></label></span><br />
                                                <label><b>Placa:    </b><i><%=plate%></i> </label><br />
                                                <label><b>Color:    </b><i><%=color%></i> </label><br />
                                                <label><b>Marca:    </b><i><%=brand%></i> </label><br />
                                                <label><b>Modelo    </b><i><%=model%></i> </label><br />
                                                <label><b>Comentarios:    </b><i><%=comments%></i> </label><br />
                                                <label><b>Tipo de vehículo:    </b><i><%=vehicleTypeId%></i> </label><br /><br />
                                                <span class="moze-important"><label><b>Información del propietario</b></label></span><br />
                                                <label><b>Identificación:    </b><i><%=identification%></i> </label><br />
                                                <label><b>Nombre:    </b><i><%=name%></i> </label><br />
                                                <label><b>Nombre de usuario:    </b><i><%=username%></i> </label><br />
                                                <label><b>Discapacidad presente:    </b><i><%=disabilityPresented%></i> </label><br />
                                            </div>
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
                    <div class="moze-wysiwyg-editor moze-no-select-border" >
                        Proyecto programación 2 - UCR 2017
                        <br/>Desarroladores: 
                        <br/>Arturo Hernández Navarro.
                        <br/>Samuel Serrano.
                    </div>
                </div>
                <br class="clear">
            </div>
        </div>
        <!-- This is a secret trap for spam robots, do not go to this link -->
        <a class="mz_notforhumans" href="/meduspods/">&nbsp;.</a>
    </body>
</html>