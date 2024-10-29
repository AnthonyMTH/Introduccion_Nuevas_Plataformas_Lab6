package com.example.myapplication
import android.app.AlertDialog
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View

class EdificioView(context: Context?) : View(context) {

    private val paint = Paint()
    private val ambientes = mutableListOf<Ambiente>()

    init {
        paint.color = Color.BLACK
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Dibujar cada ambiente
        ambientes.forEach { ambiente ->
            paint.strokeWidth = 10f
            canvas?.drawRect(ambiente.rect, paint)
            paint.strokeWidth = 3f
            drawLabel(canvas, ambiente)
        }
    }

    private fun drawLabel(canvas: Canvas?, ambiente: Ambiente) {
        paint.textSize = 40f
        canvas?.drawText(ambiente.nombre, ambiente.rect.centerX(), ambiente.rect.centerY(), paint)

    }

    fun setAmbientes(ambientes: List<Ambiente>) {
        this.ambientes.clear()
        this.ambientes.addAll(ambientes)
        invalidate() // Redibujar la vista con los nuevos datos
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            if (it.action == MotionEvent.ACTION_DOWN) {
                val x = it.x
                val y = it.y
                ambientes.forEach { ambiente ->
                    if (ambiente.rect.contains(x, y)) {
                        mostrarInformacionAmbiente(ambiente)
                        return true
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    private fun mostrarInformacionAmbiente(ambiente: Ambiente) {
        // Mostrar ventana emergente con información adicional del ambiente
        val builder = AlertDialog.Builder(context)
        builder.setTitle(ambiente.nombre)
        builder.setMessage("Información adicional del ambiente: ${ambiente.nombre}")
        builder.setPositiveButton("Cerrar", null)
        builder.show()
    }
}