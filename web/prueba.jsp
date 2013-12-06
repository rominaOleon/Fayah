<%@page import="controlador.AlbumAmigoContentControlador"%>
<%@page import="util.Util"%>
<html><head>
        <title>Lightbox Gallery</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="Author" content="httphotos">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/slimbox2.js"></script>
        <link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen">
        <style type="text/css">

            body {
                background-color: white;
                font-family: Verdana, sans-serif; font-size: larger;
                margin-bottom: 20px;
                margin-top: 0px;
                color: rgb(0, 0, 0);
                background: rgb(153, 102, 51);
            }
            td {
                text-align: center;
            }
            img {
                border-style: solid;
                border-color: rgb(0,0,0);
                border-width: 0px;
            }
            table.center {margin-left:auto; margin-right:auto;}
            #httphotos {
                position: absolute;
                right: 0px;
                bottom: 20px;
                margin: 0px;
                padding: 0px;
            }

            #httphotos img {
                border: 0px;
            }
        </style>
    </head>
    <body style="background-color: white;">
        <div>
            <table class="center">
                <tbody><tr><td></td>
                        <%
                            AlbumAmigoContentControlador.traerContenido(Util.posAlbum, Util.usuario);
                            for (int posicion = 0; posicion <= Util.listaContenido.size() - 1; posicion++) {
                        %> 
                        <td><a href="<%=Util.listaContenido.get(posicion).getContenido_url()%>" rel="lightbox-cats" title=""><img width="160px" height="150px" src="<%=Util.listaContenido.get(posicion).getContenido_url()%>" alt="Click!"></a></td>

                        <% }%>
                    </tr><tr><td></td><td></td><td></td><td></td><td></td></tr>
                </tbody></table></div>

        <div id="lbOverlay" style="opacity: 0.8; display: none;"></div>
        <div id="lbCenter" class="" style="top: 101px; width: 660px; height: 500px; margin-left: -330px; left: 640px; display: none;">
            <div id="lbImage" style="background-image: url(http://www.digicamsoft.com/demo/Lightbox_20Gallery/img00.jpg); display: block;"><div style="position: relative; width: 640px; height: 480px;"><a id="lbPrevLink" href="#" style="display: none; height: 480px;"></a><a id="lbNextLink" href="#" style="display: block; height: 480px;"></a></div></div><div style="position: relative; width: 640px; height: 480px;">
                <a id="lbPrevLink" href="#" style="display: none; height: 480px;"></a>
                <a id="lbNextLink" href="#" style="display: none; height: 480px;"></a></div></div></div>
    <div id="lbBottomContainer" style="left: 640px; width: 660px; top: 601px; margin-left: -330px; display: none;">
        <div id="lbBottom" style="margin-top: 0px;"><a id="lbCloseLink" href="#"></a>
            <div id="lbNumber">Image 12 of 12</div>
            <div style="clear: both;">
            </div></div></div></body></html>