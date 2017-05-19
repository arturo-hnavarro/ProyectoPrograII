<%-- 
    Document   : administrator_menu
    Created on : 18/05/2017, 06:57:54 PM
    Author     : Arturo
--%>


<!doctype html>

<html>

    <head>

        <title>parqueos oso polar - Menu de administrador</title>
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

        <div id="bigbar">
            <div class="mz_component mz_banner">
                <div class="moze-banner default" style="background-image: url('https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/banner-bg.jpg'); display: none"></div>

                <a class="moze-banner-slide-left" href="javascript:void(0);" rel="nofollow"></a>
                <a class="moze-banner-slide-right" href="javascript:void(0);" rel="nofollow"></a>

            </div>
            <div id="bigbar-overlay-block" class="over-bigbar">
                <div id="bigbar-container">
                    <div id="bigbar-overlay">
                        <div id="bigbar-colorizer">
                            <div class="bigbar-h1"><div class="mz_component mz_wysiwyg mz_editable">    <div class="moze-wysiwyg-editor moze-no-select-border" >
                                        Parqueos Oso Polar
                                    </div>

                                </div></div>
                            <div class="bigbar-h2"><div class="mz_component mz_wysiwyg mz_editable">    <div class="moze-wysiwyg-editor moze-no-select-border" >
                                        Iniciar sesión
                                    </div>

                                </div></div>
                        </div>
                        <a id="bigbar-down" href="#top">&nbsp;</a>
                    </div>
                </div>
            </div>
        </div>

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
                        <li class="selected"><a href="/" >Inicio</a>
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
                        <li><a href="/trabajos/" >Clientes</a>
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
                        <li><a href="/sobre-mi/" >Vehiculos</a>
                        </li>
                        <li><a href="/contacto/" >Contacto</a>
                            <ul>
                                <li><a href="/contacto/tarifas/" >Tarifas</a>
                                </li></ul>
                        </li></ul>

                </div>
                <br style="clear: both"/>
            </div>
        </div>
        <div id="belowfold">
            <div id="wrap">
                <div class="mz_component mz_menu" id="submenu">
                </div>
                <div class="mz_component mz_grid" data-cid="11025984" data-pid="2557845">

                    <div class="section section-customizable" data-rowid="1230086">
                        <div class="container">
                            <div class="gridrow">
                                <div class="column-12-12" data-cellid="1620412">
                                    <div class="mz_component mz_wysiwyg mz_editable">    <div class="moze-wysiwyg-editor moze-no-select-border" >
                                            <p><br></p>
                                        </div>

                                    </div>                        </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="bottom">
                <div class="mz_component mz_wysiwyg mz_editable">    <div class="moze-wysiwyg-editor moze-no-select-border" >
                        Proyecto programación 2
                    </div>
                </div>
                <div id="social">
                </div>
                <br class="clear">
            </div>
        </div>
        <!-- This is a secret trap for spam robots, do not go to this link -->
        <a class="mz_notforhumans" href="/meduspods/">&nbsp;.</a>



    </body>

</html>