package _3_oop

fun main() {
    val mediaPlayer = MediaPlayer()
    mediaPlayer.play()
}

interface  VideoPlayable {
    fun play() = println("Play video")
}
interface AudioPlayable {
    fun play() = println("Play audio")
}

class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}

