
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
/*5.2*/import views.html.helper.form

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Call,Form[models.Login],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/( postUrl: Call, form: Form[models.Login])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""

"""),format.raw/*13.4*/("""
"""),_display_(/*14.2*/main("Welcome to MicroBot")/*14.29*/ {_display_(Seq[Any](format.raw/*14.31*/("""

    """),format.raw/*19.8*/("""
    """),format.raw/*22.7*/("""

    """),format.raw/*24.5*/("""<h1> Welcome to Minibot Kindly log in to chat with the bot </h1>

        <head>
            <link rel="stylesheet" media="screen" href=""""),_display_(/*27.58*/routes/*27.64*/.Assets.versioned("stylesheets/main.css")),format.raw/*27.105*/("""">
        </head>

        <body id="user-login">
            <div id="content">

                <div id="user-login-form">

                    <h1>User Login</h1>

                    """),_display_(/*37.22*/request/*37.29*/.flash.data.map/*37.44*/{ case (name, value) =>_display_(Seq[Any](format.raw/*37.67*/("""
                    """),format.raw/*38.21*/("""<div>"""),_display_(/*38.27*/name),format.raw/*38.31*/(""": """),_display_(/*38.34*/value),format.raw/*38.39*/("""</div>
                    """)))}),format.raw/*39.22*/("""

                    """),format.raw/*41.82*/("""
                    """),_display_(/*42.22*/if(form.hasGlobalErrors)/*42.46*/ {_display_(Seq[Any](format.raw/*42.48*/("""
                        """),_display_(/*43.26*/form/*43.30*/.globalErrors.map/*43.47*/ { error: FormError =>_display_(Seq[Any](format.raw/*43.69*/("""
                            """),format.raw/*44.29*/("""<div>
                                Error: """),_display_(/*45.41*/error/*45.46*/.key),format.raw/*45.50*/(""": """),_display_(/*45.53*/error/*45.58*/.message),format.raw/*45.66*/("""
                            """),format.raw/*46.29*/("""</div>
                        """)))}),format.raw/*47.26*/("""
                    """)))}),format.raw/*48.22*/("""

                    """),_display_(/*50.22*/helper/*50.28*/.form(postUrl, 'id -> "user-login-form")/*50.68*/ {_display_(Seq[Any](format.raw/*50.70*/("""

                        """),_display_(/*52.26*/helper/*52.32*/.CSRF.formField),format.raw/*52.47*/("""
                        """),_display_(/*53.26*/helper/*53.32*/.inputText(
                            form("username"),
                            '_label -> "Username",
                            'placeholder -> "username",
                            'id -> "username",
                            'size -> 60
                        )),format.raw/*59.26*/("""

                        """),_display_(/*61.26*/helper/*61.32*/.inputPassword(
                            form("password"),
                            '_label -> "Password",
                            'placeholder -> "password",
                            'id -> "password",
                            'size -> 60
                        )),format.raw/*67.26*/("""

                        """),format.raw/*69.25*/("""<button>Login</button>
                        <a href="/users/register">register</a>
                    """)))}),format.raw/*71.22*/("""

                """),format.raw/*73.17*/("""</div>

            </div>

        </body>




""")))}),format.raw/*82.2*/("""
"""))
      }
    }
  }

  def render(postUrl:Call,form:Form[models.Login],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(postUrl,form)(request)

  def f:((Call,Form[models.Login]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (postUrl,form) => (request) => apply(postUrl,form)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-03-18T11:55:41.980107
                  SOURCE: /home/lekan/Documents/workspace/personal_projects/MiniBot/app/views/index.scala.html
                  HASH: a38075cc6dc02253f5f73fdf5df3210811b57377
                  MATRIX: 432->95|805->126|982->210|1011->406|1039->408|1075->435|1115->437|1148->566|1180->620|1213->626|1378->764|1393->770|1456->811|1672->1000|1688->1007|1712->1022|1773->1045|1822->1066|1855->1072|1880->1076|1910->1079|1936->1084|1995->1112|2045->1195|2094->1217|2127->1241|2167->1243|2220->1269|2233->1273|2259->1290|2319->1312|2376->1341|2449->1387|2463->1392|2488->1396|2518->1399|2532->1404|2561->1412|2618->1441|2681->1473|2734->1495|2784->1518|2799->1524|2848->1564|2888->1566|2942->1593|2957->1599|2993->1614|3046->1640|3061->1646|3359->1923|3413->1950|3428->1956|3730->2237|3784->2263|3922->2370|3968->2388|4047->2437
                  LINES: 17->5|22->6|27->7|29->13|30->14|30->14|30->14|32->19|33->22|35->24|38->27|38->27|38->27|48->37|48->37|48->37|48->37|49->38|49->38|49->38|49->38|49->38|50->39|52->41|53->42|53->42|53->42|54->43|54->43|54->43|54->43|55->44|56->45|56->45|56->45|56->45|56->45|56->45|57->46|58->47|59->48|61->50|61->50|61->50|61->50|63->52|63->52|63->52|64->53|64->53|70->59|72->61|72->61|78->67|80->69|82->71|84->73|93->82
                  -- GENERATED --
              */
          