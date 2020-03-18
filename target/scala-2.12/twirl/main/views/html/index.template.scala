
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
/*5.2*/import views.html.helper.FieldConstructor

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Call,Form[models.Login],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/( postUrl: Call, form: Form[models.Login])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""

"""),_display_(/*9.2*/main("Welcome to MicroBot")/*9.29*/ {_display_(Seq[Any](format.raw/*9.31*/("""

    """),format.raw/*11.5*/("""<h5> Welcome to Minibot Kindly log in to chat with the bot </h5>

            <div id="content">

                <div id="user-login-form">
                    """),_display_(/*16.22*/request/*16.29*/.flash.data.map/*16.44*/{ case (name, value) =>_display_(Seq[Any](format.raw/*16.67*/("""
                    """),format.raw/*17.21*/("""<div>"""),_display_(/*17.27*/name),format.raw/*17.31*/(""": """),_display_(/*17.34*/value),format.raw/*17.39*/("""</div>
                    """)))}),format.raw/*18.22*/("""

                    """),format.raw/*20.82*/("""
                    """),_display_(/*21.22*/if(form.hasGlobalErrors)/*21.46*/ {_display_(Seq[Any](format.raw/*21.48*/("""
                        """),_display_(/*22.26*/form/*22.30*/.globalErrors.map/*22.47*/ { error: FormError =>_display_(Seq[Any](format.raw/*22.69*/("""
                            """),format.raw/*23.29*/("""<div>
                                Error: """),_display_(/*24.41*/error/*24.46*/.key),format.raw/*24.50*/(""": """),_display_(/*24.53*/error/*24.58*/.message),format.raw/*24.66*/("""
                            """),format.raw/*25.29*/("""</div>
                        """)))}),format.raw/*26.26*/("""
                    """)))}),format.raw/*27.22*/("""

                    """),_display_(/*29.22*/helper/*29.28*/.form(postUrl, 'id -> "user-login-form", 'class -> "form-group")/*29.92*/ {_display_(Seq[Any](format.raw/*29.94*/("""

                        """),_display_(/*31.26*/helper/*31.32*/.CSRF.formField),format.raw/*31.47*/("""
                        """),_display_(/*32.26*/helper/*32.32*/.inputText(
                            form("username"),
                            'placeholder -> "username",
                            'id -> "username",
                            'size -> 60,
                            'class -> "form-control"
                        )),format.raw/*38.26*/("""

                        """),_display_(/*40.26*/helper/*40.32*/.inputPassword(
                            form("password"),
                            'placeholder -> "password",
                            'id -> "password",
                            'size -> 60,
                        'class -> "form-control"
                        )),format.raw/*46.26*/("""

                        """),format.raw/*48.25*/("""<button class="btn btn-primary">Login</button>
                        <a class="btn btn-success" href="/users/register">register</a>
                    """)))}),format.raw/*50.22*/("""

                """),format.raw/*52.17*/("""</div>

            </div>

        </body>




""")))}),format.raw/*61.2*/("""
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
                  DATE: 2020-03-18T21:29:48.825043
                  SOURCE: /home/lekan/Documents/workspace/personal_projects/MiniBot/app/views/index.scala.html
                  HASH: 65ae51b7033d231850dd0e6fd30c3236c62ab36d
                  MATRIX: 432->95|817->138|994->222|1022->225|1057->252|1096->254|1129->260|1318->422|1334->429|1358->444|1419->467|1468->488|1501->494|1526->498|1556->501|1582->506|1641->534|1691->617|1740->639|1773->663|1813->665|1866->691|1879->695|1905->712|1965->734|2022->763|2095->809|2109->814|2134->818|2164->821|2178->826|2207->834|2264->863|2327->895|2380->917|2430->940|2445->946|2518->1010|2558->1012|2612->1039|2627->1045|2663->1060|2716->1086|2731->1092|3032->1372|3086->1399|3101->1405|3402->1685|3456->1711|3642->1866|3688->1884|3767->1933
                  LINES: 17->5|22->6|27->7|29->9|29->9|29->9|31->11|36->16|36->16|36->16|36->16|37->17|37->17|37->17|37->17|37->17|38->18|40->20|41->21|41->21|41->21|42->22|42->22|42->22|42->22|43->23|44->24|44->24|44->24|44->24|44->24|44->24|45->25|46->26|47->27|49->29|49->29|49->29|49->29|51->31|51->31|51->31|52->32|52->32|58->38|60->40|60->40|66->46|68->48|70->50|72->52|81->61
                  -- GENERATED --
              */
          