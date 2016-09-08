class AddAwardsToKudos < ActiveRecord::Migration[5.0]
  def change
  	add_reference :kudos, :awards, foreign_key: true, null: true
  end
end
