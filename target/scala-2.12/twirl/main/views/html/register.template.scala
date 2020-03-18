
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


            """),_display_(/*7.14*/request/*7.21*/.flash.data.map/*7.36*/{ case (name, value) =>_display_(Seq[Any](format.raw/*7.59*/("""
            """),format.raw/*8.13*/("""<div>"""),_display_(/*8.19*/name),format.raw/*8.23*/(""": """),_display_(/*8.26*/value),format.raw/*8.31*/("""</div>
            """)))}),format.raw/*9.14*/("""
                """),format.raw/*10.78*/("""
                """),_display_(/*11.18*/if(registerForm.hasGlobalErrors)/*11.50*/ {_display_(Seq[Any](format.raw/*11.52*/("""
                    """),_display_(/*12.22*/registerForm/*12.34*/.globalError.map/*12.50*/{ error =>_display_(Seq[Any](format.raw/*12.60*/("""
                        """),format.raw/*13.25*/("""<div>
                            Error: """),_display_(/*14.37*/error/*14.42*/.key),format.raw/*14.46*/(""": """),_display_(/*14.49*/error/*14.54*/.message),format.raw/*14.62*/("""
                        """),format.raw/*15.25*/("""</div>
                    """)))}),format.raw/*16.22*/("""
                """)))}),format.raw/*17.18*/("""

                """),_display_(/*19.18*/helper/*19.24*/.form(postUrl, 'class -> "form-group")/*19.62*/{_display_(Seq[Any](format.raw/*19.63*/("""
                """),_display_(/*20.18*/helper/*20.24*/.CSRF.formField),format.raw/*20.39*/("""

                """),_display_(/*22.18*/helper/*22.24*/.inputText(
                    registerForm("username"),
                    '_lable -> "Username",
                    'placeholder -> "username",
                    'id -> "username",
                    'size -> 60,
                    'class -> "form-control"
                )),format.raw/*29.18*/("""

                """),_display_(/*31.18*/helper/*31.24*/.inputPassword(
                    registerForm("password"),
                    'placeholder -> "password",
                    'id -> "password",
                    'size -> 60,
                    'class -> "form-control"
                )),format.raw/*37.18*/("""

                    """),_display_(/*39.22*/helper/*39.28*/.inputText(
                    registerForm("title"),
                    'placeholder -> "Title(Mr/Mrs/Ms)",
                    'id -> "title",
                    'size -> 4,
                        'class -> "form-control"
                    )),format.raw/*45.22*/("""
                """),format.raw/*46.17*/("""<button class="btn btn-success">register</button>

                """)))}),format.raw/*48.18*/("""






            """),format.raw/*55.13*/("""</div>
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
                  DATE: 2020-03-18T21:00:16.427459
                  SOURCE: /home/lekan/Documents/workspace/personal_projects/MiniBot/app/views/register.scala.html
                  HASH: 92e6a4a64fa4122ef62a8756c1d10593b50f63c5
                  MATRIX: 771->1|955->92|983->95|1024->128|1062->129|1104->145|1119->152|1142->167|1202->190|1242->203|1274->209|1298->213|1327->216|1352->221|1402->241|1447->319|1492->337|1533->369|1573->371|1622->393|1643->405|1668->421|1716->431|1769->456|1838->498|1852->503|1877->507|1907->510|1921->515|1950->523|2003->548|2062->576|2111->594|2157->613|2172->619|2219->657|2258->658|2303->676|2318->682|2354->697|2400->716|2415->722|2719->1005|2765->1024|2780->1030|3045->1274|3095->1297|3110->1303|3380->1552|3425->1569|3524->1637|3571->1656
                  LINES: 21->1|26->2|28->4|28->4|28->4|31->7|31->7|31->7|31->7|32->8|32->8|32->8|32->8|32->8|33->9|34->10|35->11|35->11|35->11|36->12|36->12|36->12|36->12|37->13|38->14|38->14|38->14|38->14|38->14|38->14|39->15|40->16|41->17|43->19|43->19|43->19|43->19|44->20|44->20|44->20|46->22|46->22|53->29|55->31|55->31|61->37|63->39|63->39|69->45|70->46|72->48|79->55
                  -- GENERATED --
              */
          