
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[RegisterUser],Call,MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(registerForm: Form[RegisterUser], postUrl: Call)(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""

"""),_display_(/*4.2*/main("MiniBot - Register a User")/*4.35*/{_display_(Seq[Any](format.raw/*4.36*/("""


    """),format.raw/*7.5*/("""<head>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.101*/("""">
    </head>

    <body>
        <div class="content">
            <div class="register-form">
            """),_display_(/*14.14*/request/*14.21*/.flash.data.map/*14.36*/{ case (name, value) =>_display_(Seq[Any](format.raw/*14.59*/("""
            """),format.raw/*15.13*/("""<div>"""),_display_(/*15.19*/name),format.raw/*15.23*/(""": """),_display_(/*15.26*/value),format.raw/*15.31*/("""</div>
            """)))}),format.raw/*16.14*/("""
                """),format.raw/*17.78*/("""
                """),_display_(/*18.18*/if(registerForm.hasGlobalErrors)/*18.50*/ {_display_(Seq[Any](format.raw/*18.52*/("""
                    """),_display_(/*19.22*/registerForm/*19.34*/.globalError.map/*19.50*/{ error =>_display_(Seq[Any](format.raw/*19.60*/("""
                        """),format.raw/*20.25*/("""<div>
                            Error: """),_display_(/*21.37*/error/*21.42*/.key),format.raw/*21.46*/(""": """),_display_(/*21.49*/error/*21.54*/.message),format.raw/*21.62*/("""
                        """),format.raw/*22.25*/("""</div>
                    """)))}),format.raw/*23.22*/("""
                """)))}),format.raw/*24.18*/("""

                """),_display_(/*26.18*/helper/*26.24*/.form(postUrl)/*26.38*/{_display_(Seq[Any](format.raw/*26.39*/("""
                """),_display_(/*27.18*/helper/*27.24*/.CSRF.formField),format.raw/*27.39*/("""

                """),_display_(/*29.18*/helper/*29.24*/.inputText(
                    registerForm("username"),
                    '_lable -> "Username",
                    'placeholder -> "username",
                    'id -> "username",
                    'size -> 60
                )),format.raw/*35.18*/("""

                """),_display_(/*37.18*/helper/*37.24*/.inputPassword(
                    registerForm("password"),
                    '_label -> "Password",
                    'placeholder -> "password",
                    'id -> "password",
                    'size -> 60
                )),format.raw/*43.18*/("""

                    """),_display_(/*45.22*/helper/*45.28*/.inputText(
                    registerForm("title"),
                    '_label -> "Title(Mr/Mrs/Ms)",
                    'placeholder -> "Title",
                    'id -> "title",
                    'size -> 4
                    )),format.raw/*51.22*/("""
                """),format.raw/*52.17*/("""<button>register</button>

                """)))}),format.raw/*54.18*/("""






            """),format.raw/*61.13*/("""</div>
        </div>

    </body>
""")))}))
      }
    }
  }

  def render(registerForm:Form[RegisterUser],postUrl:Call,request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(registerForm,postUrl)(request)

  def f:((Form[RegisterUser],Call) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (registerForm,postUrl) => (request) => apply(registerForm,postUrl)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-03-18T11:55:41.913447
                  SOURCE: /home/lekan/Documents/workspace/personal_projects/MiniBot/app/views/register.scala.html
                  HASH: 4de94a727ee357c16d687bdb0c8ea55ed579cc46
                  MATRIX: 771->1|955->92|983->95|1024->128|1062->129|1095->136|1181->196|1195->202|1257->243|1394->353|1410->360|1434->375|1495->398|1536->411|1569->417|1594->421|1624->424|1650->429|1701->449|1746->527|1791->545|1832->577|1872->579|1921->601|1942->613|1967->629|2015->639|2068->664|2137->706|2151->711|2176->715|2206->718|2220->723|2249->731|2302->756|2361->784|2410->802|2456->821|2471->827|2494->841|2533->842|2578->860|2593->866|2629->881|2675->900|2690->906|2948->1143|2994->1162|3009->1168|3271->1409|3321->1432|3336->1438|3596->1677|3641->1694|3716->1738|3763->1757
                  LINES: 21->1|26->2|28->4|28->4|28->4|31->7|32->8|32->8|32->8|38->14|38->14|38->14|38->14|39->15|39->15|39->15|39->15|39->15|40->16|41->17|42->18|42->18|42->18|43->19|43->19|43->19|43->19|44->20|45->21|45->21|45->21|45->21|45->21|45->21|46->22|47->23|48->24|50->26|50->26|50->26|50->26|51->27|51->27|51->27|53->29|53->29|59->35|61->37|61->37|67->43|69->45|69->45|75->51|76->52|78->54|85->61
                  -- GENERATED --
              */
          